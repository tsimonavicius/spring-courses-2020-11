import React from "react";

class HelloWorld extends React.Component {
	constructor(props) {
		super(props)
		this.state = {name: "World"}
	}

	setName = (e) => {
		console.log(e.target.value)
		this.setState({name: e.target.value})
	}

	render() {
		return (
			<>
				<h1>Hello, {this.state.name}!</h1>
				<input onChange={this.setName}/>
			</>
		)
	}
}

export default HelloWorld
