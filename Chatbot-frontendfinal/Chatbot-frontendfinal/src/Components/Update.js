import { Component } from "react";
import axios from "axios";

class Update extends Component {

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
      }
      addDetails=()=>{
        const {name,id,email,phone}=this.state;
        const info={
          name:name.value,
          id:id.value,
          email:email.value,
          phone:phone.value
        }
        axios.post("",info)
        .then(response=>{
          alert("Done")
        })
      }
    }

export default Update    
   