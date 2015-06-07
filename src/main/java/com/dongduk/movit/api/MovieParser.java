package com.dongduk.movit.api;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dongduk.movit.domain.Movie;

public class MovieParser {
	private Document doc;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	
	public MovieParser() {
		
		dbFactory = null;
		dBuilder = null;
		doc = null;
		
	}
	
	public void init() throws Exception {
		
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		System.out.println("init()");
		
	}
	


	public ArrayList<Movie> getRandMovie() throws Exception {
		Random r = new Random();
	
		String imgSearchQuery;
		
		int randPageNum = r.nextInt(50) + 1;
	
	
		String qurey = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml?key=0e0d8ec52be0487be03a47862a3b7ff2&itemPerPage=30&curPage=" + Integer.toString(randPageNum);
		
		
		doc = dBuilder.parse(qurey);
		
		NodeList list = doc.getElementsByTagName("movieNm");
		ArrayList<Movie> randMovieList = new ArrayList<Movie>();
		
		for (int i = 0; i < list.getLength(); i++) {
			Movie temp = new Movie();
			
			temp.setTitle(list.item(i).getTextContent());
			//doc2 = dBuilder.parse("https://apis.daum.net/contents/movie?apikey=097a409691ace846c1eed8383ddb76d049e8f1d2&q=" + list.item(i).getTextContent() +"&output=xml");
			if (!getImgUrl(list.item(i).getTextContent()).equals("no movie")) {
				temp.setImg(getImgUrl(list.item(i).getTextContent()));
				randMovieList.add(temp);
			}
		}
		
	
		return randMovieList;
		
	}
	
	public String getImgUrl(String title) throws SAXException, IOException {
		Document doc2;
		title = URLEncoder.encode(title, "utf-8");
		
		doc2 = dBuilder.parse("https://apis.daum.net/contents/movie?apikey=097a409691ace846c1eed8383ddb76d049e8f1d2&q=" + title +"&output=xml");
		
		NodeList list = doc2.getElementsByTagName("thumbnail");
		if (list.getLength() == 0) {
			
			return "no movie";			
			
		}
		else {
	
			return list.item(0).getTextContent();
			
		}
	}
	
	public ArrayList<Movie> getBoxOffice() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyymmdd");
		String today = sf.format(cal.getTime());
		
		long date = 0;
		try {
			date = sf.parse(today).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date -= 86400000;
		Date d = new Date(date);
		String yesterday = sf.format(d);

		String query = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=0e0d8ec52be0487be03a47862a3b7ff2&targetDt=" + yesterday ;
		
		try {
			doc = dBuilder.parse(query);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Movie> boxOffice = new ArrayList<Movie>();
		
		NodeList titleList = doc.getElementsByTagName("movieNm");
		
		
		
		for (int i = 0; i < titleList.getLength(); i++) {
			Movie temp = new Movie();
			
			temp.setTitle(titleList.item(i).getTextContent());
			
			
			boxOffice.add(temp);
		}

			
		return boxOffice;
	}
	
	
	
	
}

