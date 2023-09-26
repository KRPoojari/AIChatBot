import React from "react";

class EmpInput extends React.Component 
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
      fetch("http://localhost:8081/addEmployeeInputEntity",
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

export default EmpInput;