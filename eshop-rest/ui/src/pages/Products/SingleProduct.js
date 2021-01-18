import { useParams } from "react-router-dom";
import {useEffect, useState} from "react";
import {fetchSingleProduct} from "../../api/productsApi";
import Loader from "../common/Loader";
import ProductCard from "./ProductCard";
import {getRandomText} from "../../api/loremIpsumApi";
export default () => {

    const { id } = useParams();
    const [isLoading, setLoading] = useState(true);
    const [product, setProduct] = useState();
    const [randomText, setRandomText] = useState();

    useEffect(() => {

        Promise.all([fetchSingleProduct(id), getRandomText()])
            .then((results) => {
                const response1 = results[0];
                const response2 = results[1];

                setProduct(response1.data);
                setRandomText(response2.data[0]);

            })
            .finally(() => {
                setLoading(false);
            });
    }, [])


    return (
        <>
            {isLoading && <Loader />}
            {!isLoading && <ProductCard product={product} text={randomText} />}
        </>
    )
}