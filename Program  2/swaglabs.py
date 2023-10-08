from selenium import webdriver
import time
import pytest
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import (ChromeDriverManager)
from selenium.webdriver.chrome.service import Service as ChromeService

# Initialize Chrome driver instance

driver: WebDriver = webdriver.Chrome(service=ChromeService(executable_path=ChromeDriverManager().install()))


# Navigate to the url
def test_swaglabs():
    driver.get("https://www.saucedemo.com/")
    driver.maximize_window()
    time.sleep(2)

    element = driver.find_element(By.XPATH, "/html[1]/body[1]/div[1]/div[1]/div[1]")

    search_text = "Swag Labs"
    if search_text in element.text:
        print(f"The element contains the {search_text}.")
    else:
        print(f"The element does not contain the search text: {search_text}.")

    time.sleep(3)

    driver.find_element(By.XPATH,
                        "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]").send_keys(
        "standard_user")
    time.sleep(2)

    driver.find_element(By.XPATH,
                        "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]").send_keys(
        "secret_sauce")
    time.sleep(2)

    driver.find_element(By.XPATH, "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]").click()
    time.sleep(2)

    get_product_page_url = driver.current_url
    if get_product_page_url == "https://www.saucedemo.com/inventory.html":
        print("Enters product page")

    element = driver.find_element(By.XPATH, "/html[1]/body[1]/div[1]/div[1]/div[1]")

    search_text = "Swag Labs"
    if search_text in element.text:
        print(f"The element contains the {search_text}.")
    else:
        print(f"The element does not contain the search text: {search_text}.")

    time.sleep(3)

    driver.find_element(By.XPATH, "//button[@id='add-to-cart-sauce-labs-backpack']").click()
    time.sleep(2)
    cart_count = driver.find_element(By.XPATH, "/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")
    add_count = "1"

    if add_count in cart_count.text:
        print("The cart contains item")
        driver.find_element(By.XPATH, "//a[@class='shopping_cart_link']").click()
        time.sleep(3)
        get_cart_page_url = driver.current_url
        if get_cart_page_url == "https://www.saucedemo.com/cart.html":
            print("user entered cart page")
            driver.find_element(By.XPATH, "//div[@class='cart_item']").is_displayed()
            print("cart item is displayed")
            time.sleep(3)
    else:
        print("the cart is empty")

    driver.find_element(By.XPATH, "//button[@id='react-burger-menu-btn']").click()
    time.sleep(2)
    driver.find_element(By.XPATH, "//a[@id='logout_sidebar_link']").click()
    time.sleep(2)

    assert "https://www.saucedemo.com/" in driver.current_url

    print("swag labs logout successfully")

    # get_current_url = driver.current_url
    # if get_current_url == "https://www.saucedemo.com/":
    #   print("swag labs logout successfully")


if __name__ == "__main__":
    pytest.main()

