package com.mkyong;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Hello extends WebPage {

	private static final long serialVersionUID = 1L;

	public Hello(final PageParameters parameters) {

		add(new Label("message", "Hello World, Wicket!!!!!!!!!!!!!!!!!"));
		
		// Create the modal window.  
        final ModalWindow modal;  
        add(modal = new ModalWindow("modal"));  
        modal.setCookieName("modal-1");
        
        modal.setPageCreator(new ModalWindow.PageCreator() {  
            public Page createPage() {  
                
            	// Use this constructor to pass a reference of this page.  
                return new ModalContentPage(Hello.this.getPageReference(), 
                							modal, 
                							new Page1Panel("panel"));  
            }  
        });  
        
        modal.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {  
            public void onClose(AjaxRequestTarget target) {  
            
            	System.out.println("saliendo... setWindowClosedCallback");
            }  
        });  
        modal.setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {  
            public boolean onCloseButtonClicked(AjaxRequestTarget target) {  
                
            	System.out.println("saliendo... setCloseButtonCallback");
            	return true;  
            }  
        });  
        
        // Add the link that opens the modal window.  
        add(new AjaxLink<Void>("showModalLink") {  
            @Override  
            public void onClick(AjaxRequestTarget target) {  
            	
            	System.out.println("saliendo... AjaxLink onClick");
                modal.show(target);  
            }  
        });  

	}

}
