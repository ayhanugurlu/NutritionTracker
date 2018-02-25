package com.diyetisyentakip.trackerapp.ui;


import com.diyetisyentakip.trackerapp.ui.view.CompanyView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI
public class TrackerAppUI extends UI {



    @Autowired
    SpringViewProvider springViewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Navigator navigator = new Navigator(this, this);
        springViewProvider.setAccessDeniedViewClass(CompanyView.class);
        navigator.addProvider(springViewProvider);
        navigator.setErrorView(CompanyView.class);
        navigator.navigateTo(navigator.getState());

        navigator.addView(CompanyView.NAME, CompanyView.class);



        Page.getCurrent().addPopStateListener(event -> {
            router(event.getUri());
        });

            router(CompanyView.NAME);



    }

    public void router(String route) {

        getNavigator().navigateTo(route);

    }

}
