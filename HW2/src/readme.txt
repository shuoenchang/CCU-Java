Student ID：404410053
Name：張碩恩
Department：資工三

執行方法：
	輸入make執行
	輸入make clear將class檔移除

撰寫環境：
	MacOS 10.13.4
	java version "1.8.0_60"
	Java(TM) SE Runtime Environment (build 1.8.0_60-b27)
	Java HotSpot(TM) 64-Bit Server VM (build 25.60-b23, mixed mode)

注意事項：
	兩題各自都能使用make來執行程式
	
	在Greenhouse這題中
	可以由CarbonFootprintInterfaceTest修改不同商品的使用量
	來計算出其對應Carbon一年產出量

	在Employee這題中
	可以由PayrollSystemTest來創建不同的員工資料
	程式會印出員工對應的薪資

撰寫方法：
	Employee這題基本上只是要讓我們學習何謂polymorphism
	所以基本上不會太難
	整體的程式都跟課本上一樣
	不同的地方只有在Employee另外加上一個abstract method earnings
	而getPaymentAmount只需要呼叫這個method就能知道該員工收入
	繼承自Employee的class只需要實作earnings就可以使用getPaymentAmount
	而且程式執行時會依照實際狀況(看其為哪個class)使用正確的earnings
	這就是OOP的好處，不用全部的code都重複修改

	而GreenHouse這題其實也不會算太難
	比較困難的地方是要自己上網找CarbonFoot的計算公式
	公式資料來源也都有寫在程式註解上了有需要可以點進去看
	房子的公式算是花比較多時間才找到的
	他的計算方式是由其一個月的耗電量計算
	而汽車和腳踏車則是看一年的行駛量
	不管哪一種最後計算出來的單位都是 kg CO2 per Year

心得；
	這次的作業其實不算太難
	主要就是希望大家熟悉OOP的基本原理
	而且以Employee這題來說
	code跟課本上的寫法都一樣
	所以這題的相似度可能大家都會蠻高的吧
	第二題算是混合最近話題潮流
	但是我覺得腳踏車的Carbon應該沒那麼高才對
	照理來說應該是0啊，都是使用腳哪來的Carbon
	只是作業應該不能這樣寫
	後來看的參考網站他是把人騎腳踏車所需的食物補給算進去
	但人本來就要吃了，不是因為騎腳踏車才得吃東西啊...
	所以還是覺得對腳踏車有點不公平
