import { useParams } from "react-router-dom";
import {useEffect, useState} from "react";
import {fetchSingleProduct} from "../../api/productsApi";
import Loader from "../common/Loader";
import ProductCard from "./ProductCard";
export default () => {

    const { id } = useParams();
    const [isLoading, setLoading] = useState(true);
    const [product, setProduct] = useState();

    useEffect(() => {
        fetchSingleProduct(id)
            .then(r => {
                setProduct(r.data);
            })
            .finally(() => {
                setLoading(false);
            });
    }, [])


    return (
        <>
            {isLoading && <Loader />}
            {!isLoading && <ProductCard product={product} />}
        </>
    )
}