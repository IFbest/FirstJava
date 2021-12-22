package kh1222;

class BadBank extends Bank{
	@Override
	double getInterestRate() {
		return 10.0;
	}
}
class NormalBank extends Bank{
	@Override
	double getInterestRate() {
		return 5.0;
	}
}
class GoodBank extends Bank{
	@Override
	double getInterestRate() {
		return 3.0;
	}
}

