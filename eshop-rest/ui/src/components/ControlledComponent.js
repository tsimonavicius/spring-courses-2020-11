import React from "react";
import LifecycleComponent from "./LifecycleComponent";
import LifecycleComponentHooks from "./LifecycleComponentHooks";

class ControlledComponent extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            name: 'Pirminis',
            isVisible: false,
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.hideComponent = this.hideComponent.bind(this);
    }

    handleInputChange(e) {
        console.log(e.target.value)

        this.setState({
            name: e.target.value,
            isVisible: true,
        });
    }

    hideComponent() {
        this.setState({
            isVisible: false,
        })
    }

    render() {
        const { name, isVisible } = this.state;
        return (
            <form>
                <label>Kontroliuojamas fieldas:</label>
                <br />
                Rodome: {name}
                <br />
                <input name="name" type="text" autoComplete={"off"} onChange={this.handleInputChange} />
                {/*{ isVisible && <LifecycleComponent text={name} /> }*/}
                { isVisible && <LifecycleComponentHooks text={name} /> }
                <br />
                <button type="button" onClick={this.hideComponent}> Paslepti!</button>
            </form>
        );
    }
}

export default ControlledComponent;