import MyAwesomeComponent from "./components/MyAwesomeComponent";
import Counter from "./components/Counter";
import HelloWorld from "./components/HelloWorld";
import UncontrolledComponent from "./components/UncontrolledComponent";
import ControlledComponent from "./components/ControlledComponent";
import ControlledComponentWithHooks from "./components/ControlledComponentWithHooks";
import LifecycleComponent from "./components/LifecycleComponent";

function App() {
  return (
    <div className="App">
        {/*<MyAwesomeComponent />*/}
        {/*<Counter tekstas="Niekas nepaspausta" />*/}
        {/*<HelloWorld/>*/}
        {/*<UncontrolledComponent />*/}
        {/*<ControlledComponent />*/}
        <ControlledComponent />
    </div>
  );
}

export default App;
