package edu.umass.ciir.crawling;

import edu.umass.ciir.models.LanguageModel;

import galago.parse.Document;
import galago.parse.TagTokenizer;

public class WebLanguageModelBuilder {

	private SimpleContentCrawler m_contentFetcher;
	
	public WebLanguageModelBuilder() {
		m_contentFetcher = new SimpleContentCrawler();
	}
	
	/**
	 * Downloads the URL and builds a language model from its content
	 * 
	 * @param url
	 * @return language model built from text content
	 * @throws Exception
	 */
	public LanguageModel buildLanguageModel(String url) 
	throws Exception {
		LanguageModel languageModel = new LanguageModel();
		String content = m_contentFetcher.fetchUrl(url);
		if (content != null) {
			Document d = new Document("", content);
			TagTokenizer tt = new TagTokenizer();
			tt.process(d);
			languageModel.addDocument(d, true);
		}
		return languageModel;
	}
}