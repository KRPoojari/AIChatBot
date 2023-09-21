import React, { Component, useEffect, useState } from "react";
import Faq from "react-faq-component";
 


export default function FAQs(){

    const data={
        title:"Telstra FAQ's",
        rows:[
            {
                title:"How can I download payslips?",
                content:` Go to Workday, in the home page you will be finding My payslips option, you can download your required payslip.`
            },
            {
                title:"How do I increase my voluntary provident fund contribution?",
                content:` Go to ADP portal, in the About Me section,navigate to myDetails and click the Provident fund link to update the voluntary provident fund contribution.`
            },
            {
                title:"How can we download the applications blocked in our laptops",
                content:`Go to the Ags portal, click on Manage Profile, then on Access request and select the option that suits you, then search for Avecto Temporary Access.`
            },
            {
                title:"Where should we apply for leave?",
                content:`  In the workday home page, select Request Absence, the select the required dates and submit it.`
            },
            {
                title:"Do Telstra have any website to learn about certain projects?",
                content:`  Navigate to confluence to find the insights regarding projects.`
            },
            {
                title:"How can i claim my reimbursement?",
                content:`Go to concur website, then to claim option.`
            }
        ]
    };
    
    const styles = {
        // bgColor: 'white',
        titleTextColor: "black",
        rowTitleColor: "black",
        // rowContentColor: 'grey',
        // arrowColor: "red",
    };
        return (
            <div>
                <Faq
                    data={data}
                    styles={styles}
                    
                />
            </div>
        );
    

}