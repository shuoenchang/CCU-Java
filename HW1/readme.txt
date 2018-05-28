Name: 張碩恩
Student ID: 404410053
Environment: MacOS 10.13.4, javac version=1.8.0_60

1. p.349 7.31 (Card Shuffling and Dealing)
	主要的程式運行是在Game.java裡面，他會先針對兩個不同的牌組都給予五張手牌
	接著再進行比較，看哪一組手牌較好。
	因此要測試功能正確與否請使用Game.java。

	在這次的作業中，我另外寫了一個class專門處理各自擁有的手牌(HandCards.java)。
	這個class裡面還有不同的method是可以判斷其是否有符合原則的組合。
	另外會依照 http://bit.ly/2uX8ZKZ 這裡的大小原則判斷最好的組合是哪個，並且可以與不同的手牌組進行比較。
	判斷方式為紀錄下牌組的各個花色、各個號碼的數量，再去看看數量是否符合組合所要求。
	如果有的話會順便回傳最大該組合的關鍵數字是多少。
	對這個遊戲來說，不同的花色不會有大小之分。( http://bit.ly/2H7SxwA )

	

2. p.350 7.35 (Fisher-Yates Shuffling Algorithm)
	Fisher-Yates演算法為 (ref: http://bit.ly/2IBM75J )
	/* To shuffle an array a of n elements (indices 0..n-1):
	 * for i from n − 1 downto 1 do
	 * 		j ← random integer such that 0 ≤ j ≤ i
	 * 		exchange a[j] and a[i]
	 */
	詳細實作方法可看DeckOfCards中的shuffle()函式
