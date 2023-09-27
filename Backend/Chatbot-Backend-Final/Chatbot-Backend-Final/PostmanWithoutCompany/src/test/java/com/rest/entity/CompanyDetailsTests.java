package com.rest.entity;

import com.rest.entity.CompanyDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyDetailsTests {

    @Test
    public void testCompanyDetailsGettersAndSetters() {
        
        CompanyDetails companyDetails = new CompanyDetails();
        
      
        companyDetails.setFile_name("SampleFile.pdf");
        companyDetails.setFile_type("PDF");
        companyDetails.setFile_link("http://example.com/files/sample.pdf");
        
        
        assertEquals("SampleFile.pdf", companyDetails.getFile_name());
        assertEquals("PDF", companyDetails.getFile_type());
        assertEquals("http://example.com/files/sample.pdf", companyDetails.getFile_link());
    }


}
