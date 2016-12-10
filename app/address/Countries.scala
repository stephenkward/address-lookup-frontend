package address


case class Country(name: String, alternative: String, relevance: Option[String] = None) {
  val code: String = alternative.substring(0, 2)
}


object Countries {

  val countries = List[Country](
    Country("Afghanistan", "AF افغانستان"),
    Country("Åland Islands", "AX Aaland Aland", Some("0.5")),
    Country("Albania", "AL"),
    Country("Algeria", "DZ الجزائر"),
    Country("American Samoa", "AS", Some("0.5")),
    Country("Andorra", "AD", Some("0.5")),
    Country("Angola", "AO"),
    Country("Anguilla", "AI", Some("0.5")),
    Country("Antarctica", "AQ", Some("0.5")),
    Country("Antigua And Barbuda", "AG", Some("0.5")),
    Country("Argentina", "AR"),
    Country("Armenia", "AM Հայաստան"),
    Country("Aruba", "AW", Some("0.5")),
    Country("Australia", "AU", Some("1.5")),
    Country("Austria", "AT Österreich Osterreich Oesterreich "),
    Country("Azerbaijan", "AZ"),
    Country("Bahamas", "BS"),
    Country("Bahrain", "BH البحرين"),
    Country("Bangladesh", "BD বাংলাদেশ", Some("2")),
    Country("Barbados", "BB"),
    Country("Belarus", "BY Беларусь"),
    Country("Belgium", "BE België Belgie Belgien Belgique", Some("1.5")),
    Country("Belize", "BZ"),
    Country("Benin", "BJ"),
    Country("Bermuda", "BM", Some("0.5")),
    Country("Bhutan", "BT भूटान"),
    Country("Bolivia", "BO"),
    Country("Bonaire, Sint Eustatius and Saba", "BQ"),
    Country("Bosnia and Herzegovina", "BA BiH Bosna i Hercegovina Босна и Херцеговина"),
    Country("Botswana", "BW"),
    Country("Bouvet Island", "BV"),
    Country("Brazil", "BR Brasil", Some("2")),
    Country("British Indian Ocean Territory", "IO"),
    Country("Brunei Darussalam", "BN"),
    Country("Bulgaria", "BG България"),
    Country("Burkina Faso", "BF"),
    Country("Burundi", "BI"),
    Country("Cambodia", "KH កម្ពុជា"),
    Country("Cameroon", "CM"),
    Country("Canada", "CA", Some("2")),
    Country("Cape Verde", "CV Cabo"),
    Country("Cayman Islands", "KY", Some("0.5")),
    Country("Central African Republic", "CF"),
    Country("Chad", "TD تشاد‎ Tchad"),
    Country("Chile", "CL"),
    Country("China", "CN Zhongguo Zhonghua Peoples Republic 中国/中华", Some("3.5")),
    Country("Christmas Island", "CX", Some("0.5")),
    Country("Cocos (Keeling) Islands", "CC", Some("0.5")),
    Country("Colombia", "CO"),
    Country("Comoros", "KM جزر القمر"),
    Country("Congo", "CG"),
    Country("Congo, the Democratic Republic of the", "CD Congo-Brazzaville Repubilika ya Kongo"),
    Country("Cook Islands", "CK", Some("0.5")),
    Country("Costa Rica", "CR"),
    Country("Côte d'Ivoire", "CI Cote dIvoire"),
    Country("Croatia", "HR Hrvatska"),
    Country("Cuba", "CU"),
    Country("Curaçao", "CW Curacao"),
    Country("Cyprus", "CY Κύπρος Kýpros Kıbrıs"),
    Country("Czech Republic", "CZ Česká Ceska"),
    Country("Denmark", "DK Danmark", Some("1.5")),
    Country("Djibouti", "DJ جيبوتي‎ Jabuuti Gabuuti"),
    Country("Dominica", "DM Dominique", Some("0.5")),
    Country("Dominican Republic", "DO"),
    Country("Ecuador", "EC"),
    Country("Egypt", "EG", Some("1.5")),
    Country("El Salvador", "SV"),
    Country("Equatorial Guinea", "GQ"),
    Country("Eritrea", "ER إرتريا ኤርትራ"),
    Country("Estonia", "EE Eesti"),
    Country("Ethiopia", "ET ኢትዮጵያ"),
    Country("Falkland Islands (Malvinas)", "FK", Some("0.5")),
    Country("Faroe Islands", "FO Føroyar Færøerne", Some("0.5")),
    Country("Fiji", "FJ Viti फ़िजी"),
    Country("Finland", "FI Suomi"),
    Country("France", "FR République française", Some("2.5")),
    Country("French Guiana", "GF"),
    Country("French Polynesia", "PF Polynésie française"),
    Country("French Southern Territories", "TF"),
    Country("Gabon", "GA République Gabonaise"),
    Country("Gambia", "GM"),
    Country("Georgia", "GE საქართველო"),
    Country("Germany", "DE Bundesrepublik Deutschland", Some("3")),
    Country("Ghana", "GH"),
    Country("Gibraltar", "GI", Some("0.5")),
    Country("Greece", "GR Ελλάδα", Some("1.5")),
    Country("Greenland", "GL grønland", Some("0.5")),
    Country("Grenada", "GD"),
    Country("Guadeloupe", "GP"),
    Country("Guam", "GU"),
    Country("Guatemala", "GT"),
    Country("Guernsey", "GG", Some("0.5")),
    Country("Guinea", "GN"),
    Country("Guinea-Bissau", "GW"),
    Country("Guyana", "GY"),
    Country("Haiti", "HT"),
    Country("Heard Island and McDonald Islands", "HM"),
    Country("Holy See (Vatican City State)", "VA", Some("0.5")),
    Country("Honduras", "HN"),
    Country("Hong Kong", "HK 香港"),
    Country("Hungary", "HU Magyarország"),
    Country("Iceland", "IS Island"),
    Country("India", "IN भारत गणराज्य Hindustan", Some("3")),
    Country("Indonesia", "ID", Some("2")),
    Country("Iran, Islamic Republic of", "IR ایران"),
    Country("Iraq", "IQ العراق‎"),
    Country("Ireland", "IE Éire", Some("1.2")),
    Country("Isle of Man", "IM", Some("0.5")),
    Country("Israel", "IL إسرائيل ישראל"),
    Country("Italy", "IT Italia", Some("2")),
    Country("Jamaica", "JM"),
    Country("Japan", "JP Nippon Nihon 日本", Some("2.5")),
    Country("Jersey", "JE", Some("0.5")),
    Country("Jordan", "JO الأردن"),
    Country("Kazakhstan", "KZ Қазақстан Казахстан"),
    Country("Kenya", "KE"),
    Country("Kiribati", "KI"),
    Country("Korea, Democratic People's Republic of", "KP North Korea"),
    Country("Korea, Republic of", "KR South Korea", Some("1.5")),
    Country("Kuwait", "KW الكويت"),
    Country("Kyrgyzstan", "KG Кыргызстан"),
    Country("Lao People's Democratic Republic", "LA"),
    Country("Latvia", "LV Latvija"),
    Country("Lebanon", "LB لبنان"),
    Country("Lesotho", "LS"),
    Country("Liberia", "LR"),
    Country("Libyan Arab Jamahiriya", "LY ليبيا"),
    Country("Liechtenstein", "LI"),
    Country("Lithuania", "LT Lietuva"),
    Country("Luxembourg", "LU"),
    Country("Macao", "MO"),
    Country("Macedonia, The Former Yugoslav Republic Of", "MK Македонија"),
    Country("Madagascar", "MG Madagasikara"),
    Country("Malawi", "MW"),
    Country("Malaysia", "MY"),
    Country("Maldives", "MV"),
    Country("Mali", "ML"),
    Country("Malta", "MT"),
    Country("Marshall Islands", "MH", Some("0.5")),
    Country("Martinique", "MQ"),
    Country("Mauritania", "MR الموريتانية"),
    Country("Mauritius", "MU"),
    Country("Mayotte", "YT"),
    Country("Mexico", "MX Mexicanos", Some("1.5")),
    Country("Micronesia, Federated States of", "FM"),
    Country("Moldova, Republic of", "MD"),
    Country("Monaco", "MC"),
    Country("Mongolia", "MN Mongγol ulus Монгол улс"),
    Country("Montenegro", "ME"),
    Country("Montserrat", "MS", Some("0.5")),
    Country("Morocco", "MA المغرب"),
    Country("Mozambique", "MZ Moçambique"),
    Country("Myanmar", "MM"),
    Country("Namibia", "NA Namibië"),
    Country("Nauru", "NR Naoero", Some("0.5")),
    Country("Nepal", "NP नेपाल"),
    Country("Netherlands", "NL Holland Nederland", Some("1.5")),
    Country("New Caledonia", "NC", Some("0.5")),
    Country("New Zealand", "NZ Aotearoa"),
    Country("Nicaragua", "NI"),
    Country("Niger", "NE Nijar"),
    Country("Nigeria", "NG Nijeriya Naíjíríà", Some("1.5")),
    Country("Niue", "NU", Some("0.5")),
    Country("Norfolk Island", "NF", Some("0.5")),
    Country("Northern Mariana Islands", "MP", Some("0.5")),
    Country("Norway", "NO Norge Noreg", Some("1.5")),
    Country("Oman", "OM عمان"),
    Country("Pakistan", "PK پاکستان", Some("2")),
    Country("Palau", "PW", Some("0.5")),
    Country("Palestinian Territory, Occupied", "PS فلسطين"),
    Country("Panama", "PA"),
    Country("Papua New Guinea", "PG"),
    Country("Paraguay", "PY"),
    Country("Peru", "PE"),
    Country("Philippines", "PH Pilipinas", Some("1.5")),
    Country("Pitcairn", "PN", Some("0.5")),
    Country("Poland", "PL Polska", Some("1.25")),
    Country("Portugal", "PT Portuguesa", Some("1.5")),
    Country("Puerto Rico", "PR"),
    Country("Qatar", "QA قطر"),
    Country("Réunion", "RE Reunion"),
    Country("Romania", "RO Rumania Roumania România"),
    Country("Russian Federation", "RU Rossiya Российская Россия", Some("2.5")),
    Country("Rwanda", "RW"),
    Country("Saint Barthélemy", "BL St. Barthelemy"),
    Country("Saint Helena", "SH St."),
    Country("Saint Kitts and Nevis", "KN St."),
    Country("Saint Lucia", "LC St."),
    Country("Saint Martin (French Part)", "MF St."),
    Country("Saint Pierre and Miquelon", "PM St."),
    Country("Saint Vincent and the Grenadines", "VC St."),
    Country("Samoa", "WS"),
    Country("San Marino", "SM RSM Repubblica"),
    Country("Sao Tome and Principe", "ST"),
    Country("Saudi Arabia", "SA السعودية"),
    Country("Senegal", "SN Sénégal"),
    Country("Serbia", "RS Србија Srbija"),
    Country("Seychelles", "SC", Some("0.5")),
    Country("Sierra Leone", "SL"),
    Country("Singapore", "SG Singapura  சிங்கப்பூர் குடியரசு 新加坡共和国"),
    Country("Sint Maarten (Dutch Part)", "SX"),
    Country("Slovakia", "SK Slovenská Slovensko"),
    Country("Slovenia", "SI Slovenija"),
    Country("Solomon Islands", "SB"),
    Country("Somalia", "SO الصومال"),
    Country("South Africa", "ZA RSA Suid-Afrika"),
    Country("South Georgia and the South Sandwich Islands", "GS"),
    Country("South Sudan", "SS"),
    Country("Spain", "ES España", Some("2")),
    Country("Sri Lanka", "LK ශ්‍රී ලංකා இலங்கை Ceylon"),
    Country("Sudan", "SD السودان"),
    Country("Suriname", "SR शर्नम् Sarnam Sranangron"),
    Country("Svalbard and Jan Mayen", "SJ", Some("0.5")),
    Country("Swaziland", "SZ weSwatini Swatini Ngwane"),
    Country("Sweden", "SE Sverige", Some("1.5")),
    Country("Switzerland", "CH Swiss Confederation Schweiz Suisse Svizzera Svizra", Some("1.5")),
    Country("Syrian Arab Republic", "SY Syria سورية"),
    Country("Taiwan, Province of China", "TW 台灣 臺灣"),
    Country("Tajikistan", "TJ Тоҷикистон Toçikiston"),
    Country("Tanzania, United Republic of", "TZ"),
    Country("Thailand", "TH ประเทศไทย Prathet Thai"),
    Country("Timor-Leste", "TL"),
    Country("Togo", "TG Togolese"),
    Country("Tokelau", "TK", Some("0.5")),
    Country("Tonga", "TO"),
    Country("Trinidad and Tobago", "TT"),
    Country("Tunisia", "TN تونس"),
    Country("Turkey", "TR Türkiye Turkiye"),
    Country("Turkmenistan", "TM Türkmenistan"),
    Country("Turks and Caicos Islands", "TC", Some("0.5")),
    Country("Tuvalu", "TV", Some("0.5")),
    Country("Uganda", "UG"),
    Country("Ukraine", "UA Ukrayina Україна"),
    Country("United Arab Emirates", "AE UAE الإمارات"),
    Country("United Kingdom", "GB Great Britain England UK Wales Scotland Northern Ireland", Some("2.5")),
    Country("United States", "US USA United States of America", Some("3.5")),
    Country("United States Minor Outlying Islands", "UM"),
    Country("Uruguay", "UY"),
    Country("Uzbekistan", "UZ Ўзбекистон O'zbekstan O‘zbekiston"),
    Country("Vanuatu", "VU"),
    Country("Venezuela", "VE"),
    Country("Vietnam", "VN Việt Nam", Some("1.5")),
    Country("Virgin Islands, British", "VG", Some("0.5")),
    Country("Virgin Islands, U.S.", "VI", Some("0.5")),
    Country("Wallis and Futuna", "WF", Some("0.5")),
    Country("Western Sahara", "EH لصحراء الغربية"),
    Country("Yemen", "YE اليمن"),
    Country("Zambia", "ZM"),
    Country("Zimbabwe", "ZW")
  )

  val countriesMenu: List[Country] = Country("", "Select Country") :: countries.filterNot(_.code == "GB")
}