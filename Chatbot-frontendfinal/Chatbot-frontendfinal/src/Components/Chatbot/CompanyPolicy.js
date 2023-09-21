import React, { Component } from 'react';
import GetCompanyAnswer from '../ReactComponents/GetCompanyAnswer';
import styles from './CompanyPolicy.module.css';

class CompanyPolicy extends Component{
    render(){
        return(
            <div className={styles}>
                 <form action="https://telstra.unily.com/" target="_blank">
                    <input  type="submit" value="Telstra Unily Website" />
                  </form>
                  <form action="https://askhr.inside.telstra.com/hc/en-us" target="_blank">
                      <input type="submit" value="Ask HR"/>
                  </form>
                  <form action="https://confluence.tools.telstra.com/" target="_blank">
                    <input type="submit" value="Confluence" />
                  </form>
                  <form action="https://askhr.inside.telstra.com/hc/en-us/articles/360020383638-Company-Policies" target="_blank">
                    <input type="submit" value="Company's Policies" />
                  </form>
                  <form action="https://wd3.myworkday.com/telstra/d/home.htmld" target="_blank">
                    <input type="submit" value="Workday"/>
                  </form>
                  <form action="https://jira.tools.telstra.com/" target="_blank">
                    <input type="submit" value="Jira" />
                  </form>
            </div>
        )
    }
}

export default CompanyPolicy;