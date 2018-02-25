package com.diyetisyentakip.trackerapp.ui.view;

import com.diyetisyentakip.trackerapp.model.Company;
import com.diyetisyentakip.trackerapp.repository.ICompanyRepository;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringView(name = CompanyView.NAME)
public class CompanyView extends VerticalLayout implements View {

    public static final  String NAME = "CompanyView";


    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if (companyRepository  != null) {
            this.init();
        }
    }

    private void init() {
        List<Company>  companies = companyRepository.findAll();
        Grid<Company> grid = new Grid<>();
        grid.addColumn(company -> company.getId()).setCaption("id");
        grid.addColumn(company -> company.getName()).setCaption("name");
        grid.setDataProvider(DataProvider.ofCollection(companies));
        this.addComponent(grid);
    }
}
