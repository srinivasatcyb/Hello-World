/**
 * 
 */
package com.pros;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author srinivasn
 * 
 */
public class XSLTTest {
	public static void main(String[] args)

	{

		/*if (args.length != 3)

		{

			System.err.println("give command as follows : ");

			System.err
					.println("XSLTTest data.xml converted.xsl converted.html");

			return;

		}
*/
		String dataXML = "D:\\MercurialWS\\XmltoHtmlProj\\input\\input1.xml";

		String inputXSL = "D:\\MercurialWS\\XmltoHtmlProj\\input\\inputxsl.xslt";

		String outputHTML = "D:\\MercurialWS\\XmltoHtmlProj\\output\\output.html";

		XSLTTest st = new XSLTTest();

		try

		{

			st.transform(dataXML, inputXSL, outputHTML);

		}

		catch (TransformerConfigurationException e)

		{

			System.err.println("TransformerConfigurationException");

			System.err.println(e);

		}

		catch (TransformerException e)

		{

			System.err.println("TransformerException");

			System.err.println(e);

		}

	}

	public void transform(String dataXML, String inputXSL, String outputHTML)

	throws TransformerConfigurationException,

	TransformerException

	{

		TransformerFactory factory = TransformerFactory.newInstance();

		StreamSource xslStream = new StreamSource(inputXSL);

		Transformer transformer = factory.newTransformer(xslStream);

		StreamSource in = new StreamSource(dataXML);

		StreamResult out = new StreamResult(outputHTML);

		transformer.transform(in, out);

		System.out.println("The generated HTML file is:" + outputHTML);

	}

}
