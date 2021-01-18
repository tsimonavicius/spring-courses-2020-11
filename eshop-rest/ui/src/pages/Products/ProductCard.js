import PropTypes from "prop-types";
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

function ProductCard({ product }) {

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
    });

    const classes = useStyles();

    return (

        <Card className={classes.root} variant="outlined">
            <CardContent>
                <Typography className={classes.title} color="textSecondary" gutterBottom>
                    {product.name}
                </Typography>
                <Typography variant="body2" component="p">
                    {product.description}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small">Edit description</Button>
            </CardActions>
        </Card>
    )
}

ProductCard.propTypes = {
    product: PropTypes.shape({
        name: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
    }).isRequired,
}

export default ProductCard;
