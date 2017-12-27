package PrintableSchedule;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Printer implements Printable{
	
	
	private File printFile;
	


	public Printer(File f) {
		printFile = f;
	}

	 int[] pageBreaks;  // array of page break line positions.
	 
	    /* Synthesise some sample lines of text */
	    String[] textLines;

	    
	    //Read txt file to print
	    private void readFile() throws IOException {
	    	if (textLines == null) {
				try {
					//Count lines
			        BufferedReader br = new BufferedReader(new FileReader(printFile));
			        int numLines = 0;
			        while (br.readLine() != null) numLines++;
			        br.close();
			        
			        //Read lines
			        br = new BufferedReader(new FileReader(printFile));
		            textLines = new String[numLines];

		            int o = 0;
			        while (o<numLines) {
			            textLines[o] = br.readLine();
			            o++;
			        }
			        
			        br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    	}
	    }
	    
	    /* Synthesise some sample lines of text */
	    private void initTextLines() {
	        if (textLines == null) {
	            int numLines=200;
	            textLines = new String[numLines];
	            for (int i=0;i<numLines;i++) {
	                textLines[i]= "This is line number " + i;
	            }
	        }
	    }
	 
	    //Print
	    public int print(Graphics g, PageFormat pf, int pageIndex)
	             throws PrinterException {
	 
	        Font font = new Font("Serif", Font.PLAIN, 10);
	        FontMetrics metrics = g.getFontMetrics(font);
	        int lineHeight = metrics.getHeight();
	 
	        if (pageBreaks == null) {
	        	
	        	try {
					readFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
	            int linesPerPage = (int)(pf.getImageableHeight()/lineHeight);
	            int numBreaks = (textLines.length-1)/linesPerPage;
	            pageBreaks = new int[numBreaks];
	            for (int b=0; b<numBreaks; b++) {
	                pageBreaks[b] = (b+1)*linesPerPage; 
	            }
	        }
	 
	        if (pageIndex > pageBreaks.length) {
	            return NO_SUCH_PAGE;
	        }
	 
	        /* User (0,0) is typically outside the imageable area, so we must
	         * translate by the X and Y values in the PageFormat to avoid clipping
	         * Since we are drawing text we
	         */
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.translate(pf.getImageableX(), pf.getImageableY());
	 
	        /* Draw each line that is on this page.
	         * Increment 'y' position by lineHeight for each line.
	         */
	        int y = 0; 
	        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
	        int end   = (pageIndex == pageBreaks.length)
	                         ? textLines.length : pageBreaks[pageIndex];
	        for (int line=start; line<end; line++) {
	            y += lineHeight;
	            g.drawString("           " + textLines[line], 0, y);
	        }
	 
	        /* tell the caller that this page is part of the printed document */
	        return PAGE_EXISTS;
	    }
	 


}



