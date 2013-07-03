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
		
		// Create the modal window 1.  
        addOneModalLink();  
        
        // Create the modal window 2.  
        addSecondModalLink();
        
        // Create the modal window 3.
        addThirdModalLink();

	}
	
	private void addThirdModalLink() {
		
		final ModalWindow modal;  
        add(modal = new ModalWindow("modal3"));  
        modal.setCookieName("modal-3");
        modal.setContent(new Ejemplo1Panel(modal.getContentId()));
        
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
        add(new AjaxLink<Void>("showModalLink3") {  
            @Override  
            public void onClick(AjaxRequestTarget target) {  
            	
            	System.out.println("saliendo... AjaxLink onClick");
                modal.show(target);  
            }  
        });
	}

	private void addSecondModalLink() {
		
		final ModalWindow modal;  
        add(modal = new ModalWindow("modal2"));  
        modal.setCookieName("modal-2");
        
        modal.setPageCreator(new ModalWindow.PageCreator() {  
            public Page createPage() {  
                
            	// Use this constructor to pass a reference of this page.  
                return new ModalContentPage(Hello.this.getPageReference(), 
                							modal, 
                							new Ejemplo2Panel("panel")); // este ID es el ID q esta en el HTML del ModalContentPage  
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
        add(new AjaxLink<Void>("showModalLink2") {  
            @Override  
            public void onClick(AjaxRequestTarget target) {  
            	
            	System.out.println("saliendo... AjaxLink onClick");
                modal.show(target);  
            }  
        });
	}

	private void addOneModalLink() {
		
		final ModalWindow modal;  
        add(modal = new ModalWindow("modal"));  
        modal.setCookieName("modal-1");
        
        modal.setPageCreator(new ModalWindow.PageCreator() {  
            public Page createPage() {  
                
            	// Use this constructor to pass a reference of this page.  
                return new ModalContentPage(Hello.this.getPageReference(), 
                							modal, 
                							new Ejemplo1Panel("panel"));  // este ID es el ID q esta en el HTML del ModalContentPage
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
