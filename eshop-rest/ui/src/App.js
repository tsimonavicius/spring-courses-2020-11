import MyAwesomeComponent from "./components/MyAwesomeComponent";
import Counter from "./components/Counter";
import HelloWorld from "./components/HelloWorld";
import UncontrolledComponent from "./components/UncontrolledComponent";
import ControlledComponent from "./components/ControlledComponent";
import ControlledComponentWithHooks from "./components/ControlledComponentWithHooks";
import LifecycleComponent from "./components/LifecycleComponent";
import UncontrolledComponentHooks from "./components/UncontrolledComponentHooks";
import ProductForm from "./components/ProductForm";
import ProductFormWithFormik from "./components/ProductFormWithFormik";

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
        <hr/>
        <ProductForm />
        <hr/>
        <ProductFormWithFormik/>
    </div>
  );
}

export default App;
