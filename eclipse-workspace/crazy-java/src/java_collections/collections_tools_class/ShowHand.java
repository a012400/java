package java_collections.collections_tools_class;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {

	// 定义该游戏最多支持多少个玩家
	private final int PLAY_NUM = 5;

	// 定义扑克牌的所有花色和数值
	private String[] types = { "黑桃", "红心", "梅花", "方块" };
	private String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	// cards 是一局游戏中剩下的扑克牌
	private List<String> cards = new LinkedList<String>();

	// 定义所有的玩家
	private String[] players = new String[PLAY_NUM];

	// 所有玩家手上的扑克牌
	private List<String>[] playersCards = new List[PLAY_NUM];

	/**
	 * 初始化扑克牌，放入52张牌 并且使用shuffle方法将它们按随机顺序排序
	 */
	public void initCards() {
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}
		}
		// 随机排序
		Collections.shuffle(cards);
	}

	/**
	 * 初始化玩家，为每个玩家分派用户名
	 */
	public void initPlayers(String... names) {
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("玩家数量不对");
			return;
		} else {
			// 初始化玩家用户名
			for (int i = 0; i < names.length; i++) {
				players[i] = names[i];
			}
		}
	}

	/**
	 * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空 程序使用一个长度为0的LinkedList来表示
	 */
	public void initPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}

	/**
	 * 输出全部扑克牌，该方法没有实际作用，仅用于测试
	 */
	public void showAllCards() {
		for (String card : cards) {
			System.out.println(card);
		}
	}

	/**
	 * 派扑克牌
	 * 
	 * @param first 最先派给谁
	 */
	public void deliverCard(String first) {
		// 调用ArrayUtils工具类的search方法
		// 查询出指定元素在数组中的索引
		int firstPos = ArrayUtils.search(players, first);
		// 依次给位于该指定玩家之后的每个玩家派扑克牌
		for (int i = firstPos; i < PLAY_NUM; i++) {
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		// 依次给位于该指定玩家之前的每个玩家派扑克牌
		for (int i = 0; i < firstPos; i++) {
			playersCards[i].add(cards.get(0));
			cards.remove(0);
		}
	}
	
	/**
	 * 输出玩家手上的扑克牌
	 * 实现该方法时，应该控制每个玩家看不到别人的第一张牌，但此处没有增加该功能
	 */
	public void showPlayerCards() {
		for (int i = 0; i< PLAY_NUM; i++) {
			// 当该玩家不为空时
			if (players[i] != null) {
				// 输出玩家
				System.out.print(players[i] + ": ");
				// 遍历输出玩家手上的扑克牌
				for (String card : playersCards[i]) {
					System.out.print(card + "\t");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.initPlayers("电脑玩家", "孙悟空");
		sh.initCards();
		sh.initPlayerCards();
		// 下面测试所有扑克牌，没有实际用处
		sh.showAllCards();
		System.out.println("------");
		// 下面从孙悟空开始派牌
		sh.deliverCard("孙悟空");
		sh.showPlayerCards();
	}
}
