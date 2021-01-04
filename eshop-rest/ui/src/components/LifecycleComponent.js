import React from "react";

class LifecycleComponent extends React.Component {
    constructor(props) {
        super(props);
        // props.text = //tai kas atejo is kito state!
    }

    componentDidMount() {
        console.log("Mounted... <- loadinam data")
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        const { text } = this.props;
        if (prevProps.text !== text) {
            console.log("komponentas atsinaujina!");
        }
    }

    componentWillUnmount() {
        alert("Unmounting...")
    }

    render() {
        console.log("Rendering...")
        const { text } = this.props;
        return (
            <div>Viskas ciki piki! Perduotas tekstas: { text }</div>
        );
    }
}

export default LifecycleComponent;