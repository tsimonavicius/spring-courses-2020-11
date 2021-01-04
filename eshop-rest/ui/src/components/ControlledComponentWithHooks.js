import React, { useState } from "react";

export default () => {

    const [name, setName] = useState('Pirminis naudojant use state!')

    const handleInputChange = (e) => {
        setName(e.target.value);
    }

    return (
        <form>
            <label>Kontroliuojamas fieldas:</label>
            <br />
            Rodome: {name}
            <br />
            <input name="name" type="password" onChange={handleInputChange} />
        </form>
    );
}