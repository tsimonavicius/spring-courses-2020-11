import {AppBar, Badge, CssBaseline, IconButton, Link, makeStyles, Toolbar, Typography} from "@material-ui/core";
import {NavLink, Link as RouterLink} from "react-router-dom";
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import {connect} from "react-redux";

const useStyles = makeStyles((theme) => ({
	'@global': {
		ul: {
			margin: 0,
			padding: 0,
			listStyle: 'none',
		},
	},
	appBar: {
		borderBottom: `1px solid ${theme.palette.divider}`,
	},
	toolbar: {
		flexWrap: 'wrap',
	},
	toolbarTitle: {
		flexGrow: 1,
	},
	link: {
		margin: theme.spacing(1, 1.5)
	},
	heroContent: {
		padding: theme.spacing(8, 0, 6),
	},
	cardHeader: {
		backgroundColor:
			theme.palette.type === 'light' ? theme.palette.grey[200] : theme.palette.grey[700],
	},
	cardPricing: {
		display: 'flex',
		justifyContent: 'center',
		alignItems: 'baseline',
		marginBottom: theme.spacing(2),
	},
	footer: {
		borderTop: `1px solid ${theme.palette.divider}`,
		marginTop: theme.spacing(8),
		paddingTop: theme.spacing(3),
		paddingBottom: theme.spacing(3),
		[theme.breakpoints.up('sm')]: {
			paddingTop: theme.spacing(6),
			paddingBottom: theme.spacing(6),
		},
	},
}));

const Header = ({ productCount }) => {
	const classes = useStyles()

	return (
		<>
			<CssBaseline/>
			<AppBar position="static" color="default" elevation={0} className={classes.appBar}>
				<Toolbar className={classes.toolbar}>
					<Typography variant="h6" color="inherit" noWrap className={classes.toolbarTitle}>
						Eshop
					</Typography>
					<nav>
						<Link className={classes.link} component={NavLink} to="/products">Produktai</Link>
						<Link className={classes.link} component={NavLink} to="/about">Apie sistema</Link>

						<RouterLink to="/cart">
							<IconButton aria-label="cart">
								<Badge badgeContent={productCount} color="primary">
									<ShoppingCartIcon />
								</Badge>
							</IconButton>
						</RouterLink>
					</nav>
				</Toolbar>
			</AppBar>
		</>
	)
}

const mapStateToProps = ({ cart }) => ({
	productCount: cart.length
})

export default connect(mapStateToProps, null)(Header)
