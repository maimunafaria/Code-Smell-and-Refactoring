package Workshop;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    List<String> result = new ArrayList<>();;
    List<String> convertedLine = new ArrayList<>();;
    
    
    protected String read() throws IOException 
    {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    public String toHtml() throws Exception
    {
        String htmlLines = basicHtmlEncode(read());
        return htmlLines;
    }

    private String basicHtmlEncode(String source)
    {
        this.source = source;
        char characterToConvert;
        
        for ( int i=0;i<this.source.length();i++)
        {
        	characterToConvert = source.charAt(i);
        	
        	if (characterToConvert=='<') 
        	{
            	convertedLine.add("&lt;");
            }
        	
            else if (characterToConvert=='>')
            {
            	convertedLine.add("&gt;");
            }
        	
            else if (characterToConvert=='&') 
            {
            	convertedLine.add("&amp;");
            }
        	
            else if (characterToConvert=='\n') 
            {
            	addANewLine();
            }
            else
            {
            	
            	convertedLine.add(String.valueOf(characterToConvert));
            }
        	
        }
        addANewLine();
          return String.join("<br />", result);
    }

    private void addANewLine() 
    {
        result.add(String.join("", convertedLine));
        convertedLine = new ArrayList<>();
    }

}