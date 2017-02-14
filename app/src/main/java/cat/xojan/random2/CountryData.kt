package cat.xojan.random2

class CountryData {

    private val list: List<Country> = listOf(
            Country("Austria", "xCltSU9CTQc"),
            Country("Bulgaria", "tYNMgiJ-1b0"),
            Country("Belgium", "H5q5wTBhGRA"),
            Country("Croatia", "CJqUcGBDXkE"),
            Country("Czech Republic", "yBiRTIQcO1s"),
            Country("Denmark", "ryppmnDbqJY"),
            Country("Finland", "yP9Qt-bSz40"),
            Country("Germany", "WcH9eWBs9fw"),
            Country("Armenia", "X6ATIHjjUMI"),
            Country("Iceland", "eRFT29UQY70"),
            Country("Italy", "hpMcf83glaY"),
            Country("Lithuania", "0NjkfHbK6BE"),
            Country("Luxembourg", "yjzUxDhuXig"),
            Country("Moldova", "380xwSXnzeU"),
            Country("Netherlands", "ELD2AwFN9Nc"),
            Country("Portugal", "mcehg0LG5J4"),
            Country("Slovakia", "dK4i8bmiATc"),
            Country("Slovenia", "UktXYuDQgSs"),
            Country("Switzerland", "reuJ8yVCgSM"),
            Country("Spain", "UktXYuDQgSs"),
            Country("Morocco", "FVJ1nSYP7as"),
            Country("Namibia", "NpKdOEv6Vyo"),
            Country("Iran", "SVDR-y03XX4"),
            Country("Israel", "n-HXJ7M70kA"),
            Country("Australia", "A7RvBfZL1D8"),
            Country("New Zealand", "Jp0zp3c-Al4")
    )

    val sortedList = list.sortedBy { item -> item.title }
}