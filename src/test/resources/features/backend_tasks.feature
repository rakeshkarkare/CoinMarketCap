Feature: Backend Tasks

  @backend_task1 @regression
  Scenario Outline: Retrieve ID of bitcoin, usd tether and etherium and convert them to Bolivian Boliviano
    Given User retrieve the IDs of the below currencies
      | BTC  |
      | USDT |
      | ETH  |
    Then Verify user able to convert them to Bolivian Boliviano currency as <currency>
    Examples:
      | currency |
      | BOB      |

  @backend_task2 @regression
  Scenario: Retrieve Etherium currency details and validate the response
    Given User make get info call for Ethereum with id 1027
    Then Verify the below details in the response
      | logo          | https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png |
      | technical_doc | https://github.com/ethereum/wiki/wiki/White-Paper            |
      | symbol        | ETH                                                          |
      | date_added    | 2015-08-07T00:00:00.000Z                                     |
      | platform      | null                                                         |
      | tags          | mineable                                                     |

  @backend_task3 @regression
  Scenario Outline: Retrieve info and verify tag and cryptocurrency
    Given User retrieve the info of Id <currencyID>
    Then Verify the currency is having tag value as mineable
    And Verify the currency with Id <currencyID> is having correct cryptocurrency <currencyName>
    Examples:
      | currencyID | currencyName |
      | 1          | Bitcoin      |
      | 2          | Litecoin     |
      | 3          | Namecoin     |
      | 4          | Terracoin    |
      | 5          | Peercoin     |
      | 6          | Novacoin     |
      | 7          | Devcoin      |
      | 8          | Feathercoin  |
      | 9          | Mincoin      |
      | 10         | Freicoin     |