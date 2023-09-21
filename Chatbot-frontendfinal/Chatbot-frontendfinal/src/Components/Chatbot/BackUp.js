import React, { Component } from 'react';
import ChatBot from 'react-simple-chatbot';
import CompanyPolicy from './CompanyPolicy'

class EmpInput extends Component 
{
  constructor(props) {
    super(props);
    this.state = {
      name: '', 
      id:'',
      email: '',
      phone: '',
      p:''
    };
  }
  componentWillMount() {
    const { steps } = this.props;
    const { name,id,email,phone } = steps;
    this.setState({ name, id,email,phone});
    const info={
        empName:name.value,
        empId:id.value,
        emailId:email.value,
        phone:phone.value
      } 
      fetch("http://localhost:8080/addEmployeeInputEntity",
          {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(info)
          }).then(response=>response.json())
  }
  render(){
    return(
        <div> Entered in DB </div>  
    )
  }

}

class GetAnswer extends React.Component {
    constructor(props) {
      super(props);
  
      this.state = {
        question:[],
        flag:false 
      };
    }

    componentWillMount() {
      const { steps } = this.props;
      const { question } = steps;
      fetch (`http://localhost:8080/getAnswer?question=${question.value}`,{method:"POST",})
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
            <p>{question.answer}</p> 
              </div>  
      )
    }
  
  }

class NewForm extends Component {
  render() {
    return (
      <ChatBot
      //headerTitle="Speech Synthesis"
      //speechSynthesis={{ enable: true, lang: 'en' }}
        steps={[
            {
                id:'intro',
                message:'Hello, Welcome to Telstra ChatBot!',
                trigger:'1',
                //alert(JSON.stringify(steps))
            },
          {
            id: '1',
            message: 'What is your name?',
            trigger: 'name',
          },
          {
            id: 'name',
            user: true,
            trigger: '3',
          },
          {
            id: '3',
            message: 'Hi {previousValue}! Please provide Your Employee Id?',
            trigger: 'id',
          },
          {
            id: 'id',
            user:true,
            trigger:'5'  
          },
          {
            id: '5',
            message:'What is your Email Address?',
            trigger: 'email',
          },
          {
            id:'email',
            user:true,
            validator:(value)=>{
            if(!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
                return 'Invalid email address'
              }
              return true
            },
            trigger:'6'
          },
          {
            id:'6',
            message:'Please provide your contact info',
            trigger:'phone'
          },
          {
            id:'phone',
            user:true,
            validator:(value)=>{
              if(value.length!==10){
                return 'Please provide valid contact info'
              }
              return true;
            },
            trigger:'7',
          },
          {
            id:'7',
            component:<EmpInput/>,
            trigger:'msg',
          },
          {
            id:'msg',
            message:'please select option to continue',
            trigger:'option'
          },
          {
            id:'option',
            options: [
                { value: 'policy', label: 'Company\'s policy',trigger:'company'},
                { value: 'Info', label: 'Personal Info',trigger:'personal'},
                {value:'faq',label:'FAQ\'s',end:true}
              ],
          },
          {
            id:'personal',
            message:"Type your Question below",
            trigger:'question'
          },
          {
            id:'question',
            user:true,
            trigger:'p'
          },
          {
            id:'p',
            component:<GetAnswer/>, 
            trigger:'msg2'
          },
          {
            id:'msg2',
            message:'Do you want to continue?',
            trigger:'continueoption'
          },
          {
            id:'continueoption',
            options: [
                { value: 'continue', label: 'Yes',trigger:'option'},
                { value: 'stop', label: 'No',trigger:'endapp'},
              ],
          },
          {
            id:'endapp',
            message:'Thank you for visiting Telstra ChatBot!Have a nice day!!',
            end:true
          },
          {
            id:'company',
            component:(
              <div>
                 <CompanyPolicy/>
               </div>
            ),
            trigger:'oq'
            
          }, 
          {
              id:'oq',
              options:[{value:'other',label:'Other Questions',trigger:'other ques'}],
              
          },
          {
            id:'other ques',
            message:'Please Enter Your Question',
            trigger:'question'
          },
          {
            id:'9',
            user:true,
            trigger:'10'
          },
          {
            id:'10',
            component:<GetAnswer/>, 
            end:true
          }

        ]}
      />
    );
  }
}

export default NewForm;

/*{
                question.map((ques)=>(
                    <ol key = {ques.answer}>
                        Answer: {ques.answer}
                    </ol>
                ))
            }*/
