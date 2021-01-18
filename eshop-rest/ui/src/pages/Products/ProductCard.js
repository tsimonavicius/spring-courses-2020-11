import React from 'react';
import PropTypes from "prop-types";
import { useHistory } from "react-router-dom";
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

function ProductCard({ product, text }) {

    const history = useHistory();

    const handleGoBack = () => {
        history.push("/products")
    }

    const useStyles = makeStyles({
        root: {
            minWidth: 50,
            margin: 50,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
        },
        title: {
            fontSize: 14,
            textAlign: "center"
        },
        textCenter: {
            textAlign: "center"
        },
        m1: {
            margin: 15,
        }
    });

    const classes = useStyles();

    return (
        <>
            <Button className={classes.m1} onClick={() => handleGoBack()} >Back to products</Button>
            <Card className={classes.root} variant="outlined">
                <CardContent>
                    <Typography className={classes.title} color="textSecondary" gutterBottom>
                        {product.name}
                    </Typography>
                    <Typography className={classes.textCenter} variant="body2" component="p">
                        {product.description}
                    </Typography>
                    <Typography className={classes.textCenter} variant="body2" component="p">
                        {text}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small">Edit description</Button>
                </CardActions>
            </Card>
        </>
    )
}

ProductCard.propTypes = {
    product: PropTypes.shape({
        name: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
    }).isRequired,
    text: PropTypes.string.isRequired
}

export default ProductCard;
