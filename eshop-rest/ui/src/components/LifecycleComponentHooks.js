import React, {useEffect, useState} from "react";

export default ({text}) => {

    const [isLoading, setLoader] = useState(true);
    const [extraText, setExtraText] = useState('');

    useEffect(() => {
        console.log("mounted....")

        setTimeout(() => {
            setLoader(false);
        }, 2000)

        if (text === 'ok') {
            setExtraText("!!!! JEEEE !!! Jusu ivestas teksto turinys mums labai patinka!!!")
        }

        return () => {
            console.log("updating or unmounting????????")
        }
    })

    return (
        <div>
            {isLoading && <span>Kraunasi...</span>}
            Viskas ciki piki! Perduotas tekstas su functional component: { text }
            {extraText.length > 0 && <span>{extraText}</span>}
        </div>
    );
}