import React from "react";
class CheckNwaCode extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        id:[],
        flag:false 
      };
    }
  
    componentWillMount() {
      const { steps } = this.props;
      const { nwaCode } = steps;
      fetch (`http://localhost:8081/employee/checkpwd?nwaCode=${nwaCode.value}`)
      .then((response) => response.json())
      .then((responseJson) => {
        this.setState({
            id:responseJson,
            flag:true
        });
        console.log(nwaCode.value)
        console.log(responseJson.result)
        
        this.props.obj.temp=(responseJson.result)
        console.log(this.props.obj.temp)
      })
    }
    
    render(){
      const {flag,id} = this.state;
      if(!flag) return <div>
      <p> Wait for some time....</p>
   </div>
  return(
     <div className='NewForm'>
       <p>{id.result}</p> 
         </div>  
  ) 
    }
}
 export default CheckNwaCode;