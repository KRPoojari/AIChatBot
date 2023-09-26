import React from 'react';
class GetCompanyAnswer extends React.Component {
    constructor(props) {
      super(props);
  
      this.state = {
        question:[],
        flag:false 
      };
    }

    componentWillMount() {
      const { steps } = this.props;
      const { oq2 } = steps;
      fetch (`http://localhost:8081/company/getAnswer?question=${oq2.value}`)
      .then((response) => response.json())
      .then((responseJson) => {
        this.setState({
            question:responseJson,
            flag:true
        });
        console.log(responseJson.answer)
      })
    }
    
    render(){
      const {flag,question} = this.state;
      if(!flag) return <div>
         <p> Wait for some time....</p>
      </div>
    return(
        <div className='NewForm'>
          <p>{question.description}</p>
          <a href={question.answer} target={question.answer} rel="noreferrer">
        Open Pdf
      </a>
          
            </div>  
    )
  }
  
  }

  export default GetCompanyAnswer;