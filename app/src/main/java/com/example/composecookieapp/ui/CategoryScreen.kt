package com.example.composecookieapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecookieapp.R
import com.example.composecookieapp.ui.theme.BackgroundColor
import com.example.composecookieapp.ui.theme.MainTextColor
import com.example.composecookieapp.ui.theme.SelectedColor
import com.example.composecookieapp.ui.theme.UnSelectedColor

@ExperimentalFoundationApi
@Preview
@Composable
fun CategoryScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(1f),
        topBar = { CategoryToolbar() },
        backgroundColor = BackgroundColor,
        bottomBar = { CategoryBottomNavigation(RoundedCornerShape(50)) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                shape = RoundedCornerShape(50),
                backgroundColor = SelectedColor,
                contentColor = BackgroundColor
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_menu_24),
                    "Add Button"
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Column {
            CategoryName()
            Categories()
            CategoryProductList(
                productList = listOf(
                    Product(
                        R.drawable.cookie,
                        "LKR 600",
                        "Cookie Mint",
                        true
                    ),
                    Product(
                        R.drawable.cookie,
                        "LKR 1000",
                        "Cookie Cream",
                    ),
                    Product(
                        R.drawable.cookie,
                        "LKR 250",
                        "Classic Cookie",
                    ),
                    Product(
                        R.drawable.cookie,
                        "LKR 599",
                        "Choco Cookie",
                    )
                )
            )
        }
    }
}

@Composable
fun CategoryToolbar() {
    TopAppBar(
        title = {
            Text(
                text = "Pickup",
                color = MainTextColor,
                modifier = Modifier.fillMaxWidth(1f),
                textAlign = TextAlign.Center,
            )
        },
        modifier = Modifier
            .fillMaxWidth(1f),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = "Back Icon",
                modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
            )
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.ic_notifications_24),
                contentDescription = "Notification Icon",
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
            )
        },
        backgroundColor = Color.White
    )
}

@Composable
fun CategoryName() {
    Text(
        text = "Categories", fontSize = 40.sp,
        modifier = Modifier
            .padding(15.dp, 30.dp, 0.dp, 20.dp)
            .background(BackgroundColor)
            .fillMaxWidth(1f),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Categories() {
    Row(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxWidth(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Cookies",
            color = SelectedColor,
            fontSize = 24.sp,
            modifier = Modifier.padding(15.dp, 0.dp)
        )
        Text(
            text = "Cakes",
            color = UnSelectedColor,
            fontSize = 24.sp,
            modifier = Modifier.padding(15.dp, 0.dp)
        )
        Text(
            text = "Ice Cream",
            color = UnSelectedColor,
            fontSize = 24.sp,
            modifier = Modifier.padding(15.dp, 0.dp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun CategoryProductList(productList: List<Product>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxHeight(1f),
    ) {
        items(productList.size) {
            CategoryProduct(product = productList[it])
        }
    }
}

@Composable
fun CategoryProduct(product: Product) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .border(
                1.dp,
                UnSelectedColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp, 10.dp, 10.dp, 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                    painter = if (product.hasBeenLiked) {
                        painterResource(id = R.drawable.ic_favorite_selected_24)
                    } else {
                        painterResource(id = R.drawable.ic_favorite_unselected_24)
                    }, contentDescription = "Favorite Icon",
                    tint = SelectedColor
                )
            }
            Image(
                painter = painterResource(id = product.productImage),
                contentDescription = "Product Image"
            )
            Text(text = product.productPrice, color = SelectedColor)
            Text(text = product.productName)
            Divider(
                color = UnSelectedColor, thickness = 1.dp,
                modifier = Modifier.padding(10.dp, 10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_shopping_basket_24),
                    contentDescription = "Basket Icon",
                    tint = SelectedColor
                )
                Text(text = "Add to cart", color = SelectedColor)
            }
        }
    }
}

@Composable
fun CategoryBottomNavigation(fabshape: RoundedCornerShape) {
    val items = listOf(
        CategoryBottomNavItem(
            itemIcon = R.drawable.ic_home_24,
            itemTitle = "Home"
        ),
        CategoryBottomNavItem(
            itemIcon = R.drawable.ic_person_24,
            itemTitle = "Account"
        ),
        CategoryBottomNavItem(
            itemIcon = R.drawable.ic_search_24,
            itemTitle = "Search"
        ),
        CategoryBottomNavItem(
            itemIcon = R.drawable.ic_shopping_basket_24,
            itemTitle = "Basket"
        ),
    )
    BottomAppBar(
        elevation = 10.dp,
        backgroundColor = Color.White,
        contentColor = Color.White,
        cutoutShape = fabshape
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.itemIcon),
                        contentDescription = item.itemTitle
                    )
                },
                selectedContentColor = SelectedColor,
                unselectedContentColor = UnSelectedColor,
                alwaysShowLabel = true,
                selected = index == 0,
                onClick = {}
            )
        }
    }
}
