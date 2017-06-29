package com.sendo.coding_question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OxfordScraper {
	public static final String base_oxford = "http://www.oxfordlearnersdictionaries.com/search/english/direct/?q=";
	
	public static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    public static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
	
	public void parseUrl(String url, String idiom, String file) throws IOException {
        //print("Fetching %s", url);

        Document doc = Jsoup.connect(url).get();
        Elements idm_g = doc.select(".idm-gs .idm-g");
        //String data = (idm_g.html());
        
        List<String> data = new ArrayList<String>();
        
        for(Element e : idm_g) {
        	//data.add(e.html() + "\n\n");
        	WordMeaning w = parseElement(e, idiom);
        	if(w != null) {
        		data.add(w.toResult());
        		break;
        	}
        }
        
        Utils.writeFile(file, data);
        
	}
	
	public WordMeaning parseElement(Element e, String idiom) {
		WordMeaning w = new WordMeaning();
		String word = null;
		try {
			//System.out.println("\n------------");
			word = e.select("div.top-g span.idm").text();
			//System.out.println(word);
			w.setWord(word);
			
			Elements defines = e.select(".sn-gs .sn-g");
			
			for(Element d : defines) {
				Meaning m = new Meaning();
				
				String use = d.select(".use").text();
				if(!use.isEmpty())
					use = use + " ";
				String dis = d.select(" .dis-g").text();
				if(!dis.isEmpty())
					dis = dis + " ";
				String def = d.select(".def").text();
				String meaning = use + dis + def;
				//System.out.println(meaning);
				m.setMeaning(meaning.trim());
				
				Elements exs = d.select(".x-g");
				for(Element exp: exs) {
					String example = exp.text();
					m.addExample(example);
					//System.out.println(example);
				}
				
				w.addMeaning(m);
			}
			//System.out.println("------------\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if(idiom.equals(word))
			return w;
		else {
			return null;
		}
	}
	
	public void extract(String idiom, String outFile) {
		String filtered = filterIdiom(idiom);
		
		try {
			parseUrl(queryUrl(filtered), filtered, outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String filterIdiom(String idiom) {
		String after = idiom.trim().replaceAll(" +", " ");
		return after;
	}
	
	public String queryUrl(String idiom) {
		return base_oxford + idiom;//.replace(" ", "+");
	}
	
	public String generateResult(List<Meaning> meanings) {
		String result = "";
		
		for(int i = 0 ; i < meanings.size() ; i ++) {
			result += "\n" + meanings.get(i).toResult(i+1);
		}
		if(result.length() > 0)
			result = result.substring(1, result.length());
		
		return result;
	}
	

	

}
