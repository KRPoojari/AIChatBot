import React from "react";

class GetPersonalAnswer extends React.Component {
    constructor(props) {
      super(props);
  
      this.state = {
        question:[],
        flag:false 
      };
    }

    componentWillMount() {
      const { steps } = this.props;
      const { question,id } = steps;
      fetch (`http://localhost:8081/employee/getAnswers?question=${question.value}&empId=${id.value}`)
      .then((response) => response.json())
      .then((responseJson) => {
        this.setState({
            question:responseJson,
            flag:true
        });
        console.log(responseJson.answer)
        //console.log(typeof(this.props.myObj1))
        this.props.myObj.em += responseJson.answer
        console.log(this.props.myObj.em)
      })
      
      
    }
    
    
    render(){

      const {flag,question} = this.state;
      
      //this.props.myObj.em += question.answer;
      //console.log(this.props.myObj.em)
      if(!flag) return <div>
         <p> Wait for some time....</p>
      </div>
    return(
        <div className='Form'>
          <p>{question.answer}</p> 
            </div>  
    ) 
  }
  
  }

  export default GetPersonalAnswer;