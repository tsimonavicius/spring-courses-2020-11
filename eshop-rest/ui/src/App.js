import MyAwesomeComponent from "./components/MyAwesomeComponent";
import Counter from "./components/Counter";
import HelloWorld from "./components/HelloWorld";
import UncontrolledComponent from "./components/UncontrolledComponent";
import ControlledComponent from "./components/ControlledComponent";
import ControlledComponentWithHooks from "./components/ControlledComponentWithHooks";
import LifecycleComponent from "./components/LifecycleComponent";
import UncontrolledComponentHooks from "./components/UncontrolledComponentHooks";

function App() {
  return (
    <div className="App">
        {/*<MyAwesomeComponent />*/}
        {/*<Counter tekstas="Niekas nepaspausta" />*/}
        {/*<HelloWorld/>*/}
        {/*<UncontrolledComponent />*/}
        {/*<UncontrolledComponentHooks />*/}
        {/*<ControlledComponent />*/}
        <ControlledComponent />
    </div>
  );
}

export default App;
