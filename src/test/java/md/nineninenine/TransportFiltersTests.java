package md.nineninenine;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TransportFiltersTests {

	public ChromeDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void firstRoLangFiltersTest() {
		String url = "https://999.md/ro/list/transport/cars";
		driver.get(url);

		// Активируем чекбокс марка автомобиля "Skoda"
		WebElement filterCarBrand = driver.findElement(By.id("option-143"));
		WebElement filterCarBrandTag = driver.findElement(By.xpath("//label[@for='toggle-143']/span"));
		filterCarBrand.click();

		String expectedFilterCarBrandText = filterCarBrandTag.getText();
		System.out.println(expectedFilterCarBrandText);

		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("option-776")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Продам"
		WebElement filterSell = driver.findElement(By.id("option-776"));
		WebElement filterSellTextTag = driver.findElement(By.xpath("//label[@for='option-776']"));
		String filterSellText = filterSellTextTag.getText();
		System.out.println(filterSellText);
		filterSell.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Электростеклоподъемники" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='136']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterElectroWindow = driver.findElement(By.xpath("//input[@value='136']"));
		filterElectroWindow.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterElectroWindowTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterElectroWindowText = filterElectroWindowTag.getText();
		System.out.println(expectedFilterElectroWindowText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}
			WebElement resultFilterType = driver.findElement(By.className("adPage__aside__stats__type"));
			String actualTypeText = resultFilterType.getText();
			String[] extractTypeText = actualTypeText.split(" ");
			Assert.assertEquals(filterSellText, extractTypeText[1]);

			WebElement resultFilterModel = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"+ expectedFilterCarBrandText + "')]]"));
			String actualModelText = resultFilterModel.getText();
			Assert.assertEquals(actualModelText, expectedFilterCarBrandText);

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"
							+ expectedFilterElectroWindowText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();
			Assert.assertEquals(actualComfortText, expectedFilterElectroWindowText);
		}
	}
	@Test
	public void firstRuLangFiltersTest() {
		String url = "https://999.md/ru/list/transport/cars";
		driver.get(url);

		// Активируем чекбокс марка автомобиля "Skoda"
		WebElement filterCarBrand = driver.findElement(By.id("option-143"));
		WebElement filterCarBrandTag = driver.findElement(By.xpath("//label[@for='toggle-143']/span"));
		filterCarBrand.click();

		String expectedFilterCarBrandText = filterCarBrandTag.getText();
		System.out.println(expectedFilterCarBrandText);

		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("option-776")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Продам"
		WebElement filterSell = driver.findElement(By.id("option-776"));
		WebElement filterSellTextTag = driver.findElement(By.xpath("//label[@for='option-776']"));
		String filterSellText = filterSellTextTag.getText();
		System.out.println(filterSellText);
		filterSell.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Электростеклоподъемники" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='136']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterElectroWindow = driver.findElement(By.xpath("//input[@value='136']"));
		filterElectroWindow.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterElectroWindowTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterElectroWindowText = filterElectroWindowTag.getText();
		System.out.println(expectedFilterElectroWindowText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}
			WebElement resultFilterType = driver.findElement(By.className("adPage__aside__stats__type"));
			String actualTypeText = resultFilterType.getText();
			String[] extractTypeText = actualTypeText.split(" ");
			Assert.assertEquals(filterSellText, extractTypeText[1]);

			WebElement resultFilterModel = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"+ expectedFilterCarBrandText + "')]]"));
			String actualModelText = resultFilterModel.getText();
			Assert.assertEquals(actualModelText, expectedFilterCarBrandText);

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"
							+ expectedFilterElectroWindowText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();
			Assert.assertEquals(actualComfortText, expectedFilterElectroWindowText);
		}
	}
	@Test
	public void secondRoLangFiltersTest() {
		String url = "https://999.md/ro/list/transport/cars";
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 3);

		// Заполняем поле "Цена"
		WebElement filterPriceMin = driver
				.findElement(By.xpath("//div[@class='items__filters__filter__content__range__from']/input"));
		filterPriceMin.sendKeys("4000");
		WebElement filterPriceMax = driver
				.findElement(By.xpath("//div[@class='items__filters__filter__content__range__to']/input"));
		filterPriceMax.sendKeys("8000");

		// Деактивируем чекбокс "показывать объявления с договорной ценой" в блоке
		// "Цена"
		WebElement negotiablePrice = driver.findElement(By.id("form--show-negotiable"));
		negotiablePrice.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Молдова" в блоке "Регистрация"
		WebElement registerCountry = driver.findElement(By.id("option-18592"));
		WebElement registerCountryTextTag = driver.findElement(By.xpath("//label[@for='option-18592']"));
		String expectedRegisterCountryText = registerCountryTextTag.getText();
		System.out.println(expectedRegisterCountryText);
		registerCountry.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Электростеклоподъемники" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='130']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterAirConditioning = driver.findElement(By.xpath("//input[@value='130']"));
		filterAirConditioning.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterAirConditioningTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterAirConditioningText = filterAirConditioningTag.getText();
		System.out.println(expectedFilterAirConditioningText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}

			WebElement resultFilterPrice = driver
					.findElement(By.className("adPage__content__price-feature__prices__price__value"));
			int actualPriceNumber = Integer.parseInt(resultFilterPrice.getText().replaceAll("\\s", ""));

			Assert.assertTrue(actualPriceNumber >= 4000);
			Assert.assertTrue(actualPriceNumber <= 8000);

			WebElement resultFilterCountryRegistration = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'" + expectedRegisterCountryText + "')]]"));
			String actualCountryRegistrationText = resultFilterCountryRegistration.getText();
			Assert.assertEquals(actualCountryRegistrationText, expectedRegisterCountryText);

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'" + expectedFilterAirConditioningText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();
			Assert.assertEquals(actualComfortText, expectedFilterAirConditioningText);
		}
	}
	@Test
	public void secondRuLangFiltersTest() {
		String url = "https://999.md/ru/list/transport/cars";
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 3);

		// Заполняем поле "Цена"
		WebElement filterPriceMin = driver
				.findElement(By.xpath("//div[@class='items__filters__filter__content__range__from']/input"));
		filterPriceMin.sendKeys("4000");
		WebElement filterPriceMax = driver
				.findElement(By.xpath("//div[@class='items__filters__filter__content__range__to']/input"));
		filterPriceMax.sendKeys("8000");

		// Деактивируем чекбокс "показывать объявления с договорной ценой" в блоке
		// "Цена"
		WebElement negotiablePrice = driver.findElement(By.id("form--show-negotiable"));
		negotiablePrice.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Молдова" в блоке "Регистрация"
		WebElement registerCountry = driver.findElement(By.id("option-18592"));
		WebElement registerCountryTextTag = driver.findElement(By.xpath("//label[@for='option-18592']"));
		String expectedRegisterCountryText = registerCountryTextTag.getText();
		System.out.println(expectedRegisterCountryText);
		registerCountry.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@data-filter-id='1077']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Кондиционер" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='130']")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterAirConditioning = driver.findElement(By.xpath("//input[@value='130']"));
		filterAirConditioning.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterAirConditioningTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterAirConditioningText = filterAirConditioningTag.getText();
		System.out.println(expectedFilterAirConditioningText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}

			WebElement resultFilterPrice = driver
					.findElement(By.className("adPage__content__price-feature__prices__price__value"));
			int actualPriceNumber = Integer.parseInt(resultFilterPrice.getText().replaceAll("\\s", ""));

			Assert.assertTrue(actualPriceNumber >= 4000);
			Assert.assertTrue(actualPriceNumber <= 8000);

			WebElement resultFilterCountryRegistration = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'" + expectedRegisterCountryText + "')]]"));
			String actualCountryRegistrationText = resultFilterCountryRegistration.getText();
			Assert.assertEquals(actualCountryRegistrationText, expectedRegisterCountryText);

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'" + expectedFilterAirConditioningText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();
			Assert.assertEquals(actualComfortText, expectedFilterAirConditioningText);
		}
	}
	@Test
	public void thirdRoLangFiltersTest() {
		String url = "https://999.md/ro/list/transport/cars";
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 3);

		// Выбираем марку "Vectra" в разделе "Opel"
		WebElement showAllModels = driver
				.findElement(By.xpath("//label[@class='items__filters__filter__content__show-more']"));
		showAllModels.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement openlModelHonda = driver
				.findElement(By.xpath("//div[@data-filter-id='1']//*[text()[contains(.,'Honda')]]"));
		openlModelHonda.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement selectMarkAccord = driver.findElement(By.xpath("//input[@id='option-163']"));
		selectMarkAccord.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Регулируемая по вылету рулевая колонка" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterSteeringColumn = driver.findElement(By.xpath("//input[@value='134']"));
		filterSteeringColumn.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterSteeringColumnTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterSteeringColumnText = filterSteeringColumnTag.getText();
		System.out.println(expectedFilterSteeringColumnText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}

			WebElement resultFilterBrand = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'Honda')]]"));

			String acutalFilterBrandText = resultFilterBrand.getText();

			WebElement resultFilterModel = driver.findElement(
					By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'Accord')]]"));

			String acutalFilterModelText = resultFilterModel.getText();

			Assert.assertEquals(acutalFilterBrandText, "Honda");
			Assert.assertEquals(acutalFilterModelText, "Accord");

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"
							+ expectedFilterSteeringColumnText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();

			Assert.assertEquals(actualComfortText, expectedFilterSteeringColumnText);
		}
	}
	@Test
	public void thirdRuLangFiltersTest() {
		String url = "https://999.md/ru/list/transport/cars";
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 3);

		// Выбираем марку "Vectra" в разделе "Opel"
		WebElement showAllModels = driver
				.findElement(By.xpath("//label[@class='items__filters__filter__content__show-more']"));
		showAllModels.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement openlModelHonda = driver
				.findElement(By.xpath("//div[@data-filter-id='1']//*[text()[contains(.,'Honda')]]"));
		openlModelHonda.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement selectMarkAccord = driver.findElement(By.xpath("//input[@id='option-163']"));
		selectMarkAccord.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		// Активируем чекбокс "Регулируемая по вылету рулевая колонка" в блоке "Комфорт"
		WebElement filterComfort = driver.findElement(By.xpath("//div[@data-filter-id='1077']"));
		filterComfort.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterSteeringColumn = driver.findElement(By.xpath("//input[@value='134']"));
		filterSteeringColumn.click();

		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("js-ads-filters")));
		} catch (TimeoutException e) {
			sleep(3000);
		}

		WebElement filterSteeringColumnTag = driver
				.findElement(By.xpath("//li[@class='items__filters__filter__content__list__item is-checked']//span"));
		String expectedFilterSteeringColumnText = filterSteeringColumnTag.getText();
		System.out.println(expectedFilterSteeringColumnText);

		ArrayList<String> advertisements = fetchAllLinksOnPage(driver.getCurrentUrl(), 1);

		for (String advertisement : advertisements) {
			driver.get(advertisement);

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("adPage__aside__stats__type")));
			} catch (TimeoutException e) {
				sleep(3000);
			}

			WebElement resultFilterBrand = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'Honda')]]"));

			String acutalFilterBrandText = resultFilterBrand.getText();

			WebElement resultFilterModel = driver.findElement(
					By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'Accord')]]"));

			String acutalFilterModelText = resultFilterModel.getText();

			Assert.assertEquals(acutalFilterBrandText, "Honda");
			Assert.assertEquals(acutalFilterModelText, "Accord");

			WebElement resultFilterComfort = driver
					.findElement(By.xpath("//div[@class='adPage__content__features']//*[text()[contains(.,'"
							+ expectedFilterSteeringColumnText + "')]]"));
			String actualComfortText = resultFilterComfort.getText();

			Assert.assertEquals(actualComfortText, expectedFilterSteeringColumnText);
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	

	/**
	 * link - ссылка на рубрику с указанием языка "RO/RU"; pageCount - кол-во
	 * страниц. Влияет на кол-во обрабатываемых объявлений
	 */
	private ArrayList<String> fetchAllLinksOnPage(String link, int pageCount) {
		List<WebElement> targets = new ArrayList<>();
		ArrayList<String> links = new ArrayList<String>();
		for (int i = 1; i <= pageCount; i++) {
			int page = i;
			targets = driver.findElements(By.xpath("//div[@class='ads-list-photo-item-title ']/a"));

			for (WebElement target : targets) {
				int indexWord = target.getAttribute("href").indexOf("booster");
				if (indexWord == -1) {
					links.add(target.getAttribute("href"));
				} else {
					continue;
				}
			}
			driver.get(link + "&page=" + page);
		}

		return links;
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}