import MyAwesomeComponent from "./components/MyAwesomeComponent";
import Counter from "./components/Counter";
import HelloWorld from "./components/HelloWorld";

function App() {
  return (
    <div className="App">
        <MyAwesomeComponent />
        <Counter tekstas="Niekas nepaspausta" />
        <HelloWorld/>
    </div>
  );
}

export default App;
