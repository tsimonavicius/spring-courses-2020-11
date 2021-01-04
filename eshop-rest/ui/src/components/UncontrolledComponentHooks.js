import React, {useRef, useState} from "react";

export default () => {

    const nameInput = useRef('')
    const ref = useRef(null)
    const [studentName, setStudentName] = useState("Bevardis");

    const handleSubmit = (e) => {
        e.preventDefault();
        const name = nameInput.current.value;

        console.log("you clicked submit! Your ref value: ", ref.current.value);

        console.log('btn: ', ref.current.value)
        setStudentName(name)
    }

    return (
        <form onSubmit={handleSubmit}>
            Studento vardas: {studentName}
            <br />
            <label>Nekontroliuojamas fieldas su hooks:</label>
            <br />
            <input name="name" type="password" ref={nameInput} />
            <br />
            <button type="submit" >Pirmyn!</button>
            <select name={'smth'} ref={ref}>
                <option >Petras</option>
                <option>Elvis</option>
                <option>Rokas</option>
            </select>
        </form>
    );
}