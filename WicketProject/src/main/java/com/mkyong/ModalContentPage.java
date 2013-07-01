package com.mkyong;

import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;

public class ModalContentPage extends WebPage {  
	
    public ModalContentPage(final PageReference modalWindowPage,  
							final ModalWindow window, 
							Panel innerPannel) {
    	
//    	this(modalWindowPage, window);
    	
    	System.out.println("Entroooo");
    	add(innerPannel);
    	add(new AjaxLink("close") {
            public void onClick(AjaxRequestTarget target) {
                window.close(target);
            }
        });
    }

  
   

}
