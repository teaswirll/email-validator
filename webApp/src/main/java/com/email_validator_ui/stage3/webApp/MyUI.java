package com.email_validator_ui.stage3.webApp;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField email = new TextField();
        email.setCaption("Type a valid gmail address here:");
        
        Button button = new Button("Validate");
        button.addClickListener( e -> {
        	if( validator.validate( email.getValue()) == 4) {
        		Notification.show("Email is valid", Type.TRAY_NOTIFICATION);
        	} else {
        		if( !validator.sizeValid(email.getValue())) {
        			Notification.show("Email is too short", Type.WARNING_MESSAGE);
        		} else if( !validator.atValid(email.getValue())) {
        			Notification.show("Too few or too many @ in email address" , Type.WARNING_MESSAGE);
        		} else if( !validator.pointValid(email.getValue())) {
        			Notification.show("No dots in email address", Type.WARNING_MESSAGE);
        		} else if( !validator.gmailValid(email.getValue())) {
        			Notification.show("Not a valid gmail address", Type.WARNING_MESSAGE);
        		}
        	}
        });
        
        layout.addComponents(email, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
}
