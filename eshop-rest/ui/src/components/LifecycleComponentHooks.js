import React, { useEffect } from "react";

export default ({text}) => {

    useEffect(() => {
        console.log("mounted....")
        return () => {
            console.log("updating or unmounting????????")
        }
    })

    return (
        <div>Viskas ciki piki! Perduotas tekstas su functional component: { text }</div>
    );
}