import React from "react";

class UncontrolledComponent extends React.Component {
    constructor(props) {
        super(props);

        this.nameInput = React.createRef();

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        console.log("you clicked submit! Your ref value: ", this.nameInput.current.value);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>Nekontroliuojamas fieldas:</label>
                <br />
                <input name="name" type="password" ref={this.nameInput} />
                <br />
                <button type="submit">Pirmyn!</button>
            </form>
        );
    }
}

export default UncontrolledComponent;