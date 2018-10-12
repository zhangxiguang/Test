package SuperMarket;

import java.util.Random;
import java.util.Scanner;

public class SuperMarket {
	static String adminname = "admin";
	static String adminpsd = "123";
	static int err = 0; // 错误次数
	static int err2 = 3 - err;// 还剩下的错误次数

	static int a = 0;// 定义商品名字
	static int b = 0;// 定义商品编号
	static int c = 0;// 定义商品价格
	static int d = 0;// 定义商品数量
	static int e = 0;// 定义商品产地
	static int f = 0;
	static int g = 0;
	static int h = 0;
	static String[] shopmz = new String[1000];// 定义商品名字数组
	static int[] shopbh = new int[1000]; // 定义商品编号数组
	static int[] shopjg = new int[1000]; // 定义商品价格数组
	static int[] shopsl = new int[1000]; // 定义商品数量数组
	static String[] shopgs = new String[1000];// 定义商品公司数组

	static int yemian = 0; // 页面总数
	static int yemian2 = 0; // 当前页面数
	static int yemian2s = 0; // 当前页面数(用于输出页面)
	static int number = 0; // 当前页输出信息个数
	static String[][] page = new String[yemian][10];

	static String[] usermz = new String[1000];// 定义用户信息数组
	static String[] userbh = new String[1000];// 定义用户信息数组
	static String[] userjg = new String[1000];// 定义用户信息数组
	static String[] usersl = new String[1000];// 定义用户信息数组

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() { // 主界面
		System.out.println("******************************");
		System.out.println("*****欢迎使用就是好牌超市管理系统*****");
		System.out.println("******************************");
		System.out.println("请选择功能: 1.登陆   2.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (true) {
			if (num == 1) {
				login();
				break;
			} else if (num == 2) {
				System.exit(0);
			} else {
				System.err.println("输入错误，请重新输入");
				num = sc.nextInt();

			}
		}
	}

	public static void login() { // 登陆函数
		while (err < 3) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入管理员账号:");
			String input = sc.next();
			System.out.println("请输入管理员密码:");
			String input2 = sc.next();

			if (input.equals(adminname) && input2.equals(adminpsd)) {
				System.out.println("恭喜！登陆成功！");
				err = 3;
				// flag=true;
				menu();
			} else { // 判断输入次数，连续三次出错将退出程序
				err++;
				err2 = 3 - err;
				System.err.println("账号或密码错误。连续3次输入错误将退出程序！");
				System.out.println("请注意！当前还剩" + err2 + "次机会！");
				while (err < 3) {
					System.out.println("重新输入请按1，返回上一层请按2，退出程序请按3");
					int input3 = sc.nextInt();
					if (input3 == 1) {
						login();
					} else if (input3 == 2) {
						showMenu();
					} else if (input3 == 3) {
						System.exit(0);
					} else {
						System.err.println("输入错误，请重新输入");
						input3 = sc.nextInt();
					}
				}

			}
		}

	}

	public static void menu() { // 菜单
		System.out.println("请选择功能:");
		System.out.println("1.商品管理");
		System.out.println("2.用户管理");
		System.out.println("3.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			shop();
			break;
		case 2:
			user();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.err.println("输入错误，请重新输入，如果返回上一层请按4，退出程序请按5");
			int pd = sc.nextInt();
			boolean flag = true;
			while (flag == true) {
				if (pd == 1) {
					shop();
					break;
				} else if (pd == 2) {
					user();
					break;
				} else if (pd == 3) {
					System.exit(0);
					break;
				} else if (pd == 4) {
					menu();
					break;
				} else if (pd == 5) {
					System.exit(0);
					break;
				} else {
					System.err.println("输入错误,请重新输入，如果想返回上一层请按3，退出程序请按4");
					pd = sc.nextInt();
					if (pd == 3) {
						menu();
						break;
					} else if (pd == 4) {
						System.exit(0);
						break;
					}
					continue;
				}
			}
		}
	}

	public static void shop() { // 商品管理界面
		System.out.println("**************************");
		System.out.println("*******请选择功能:***********");
		System.out.println("       1.添加商品");
		System.out.println("       2.删除商品");
		System.out.println("       3.修改商品");
		System.out.println("       4.查看商品");
		System.out.println("       5.返回上层");
		System.out.println("       6.退出系统");
		System.out.println("**************************");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			addshop();
			break;
		case 2:
			delshop();
			break;
		case 3:
			modshop();
			break;
		case 4:
			broshop();
			break;
		case 5:
			menu();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.err.println("输入错误，请重新输入，如果返回上一层请按7，退出程序请按8");
			int pd = sc.nextInt();
			boolean flag = true;
			while (flag == true) {
				if (pd == 1) {
					addshop();
					break;
				} else if (pd == 2) {
					delshop();
					break;
				} else if (pd == 3) {
					modshop();
					break;
				} else if (pd == 4) {
					broshop();
					break;
				} else if (pd == 7) {
					menu();
					break;
				} else if (pd == 8) {
					System.exit(0);
					break;
				} else {
					System.err.println("输入错误,请重新输入，如果想返回上一层请按7，退出程序请按8");
					pd = sc.nextInt();
					if (pd == 7) {
						menu();
						break;
					} else if (pd == 8) {
						System.exit(0);
						break;
					}
					continue;
				}
			}

		}

	}

	public static void addshop() { // 添加商品
		System.out.println("请选择：1、单次录入、2.随机添加");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("请输入以下信息：");
			System.out.println("1.商品名称     2.商品编号    3.商品价格    4.商品数量    5.商品产地 ");
			System.out.println("1.商品名称：");
			String name = sc.next();
			shopmz[a] = name;
			a++;
			System.out.println("2.商品编号：");
			int bh = sc.nextInt();
			shopbh[b] = bh;
			b++;
			System.out.println("3.商品价格：");
			int jg = sc.nextInt();
			shopjg[c] = jg;
			c++;
			System.out.println("4.商品数量：");
			int sl = sc.nextInt();
			shopsl[d] = sl;
			d++;
			System.out.println("5.商品公司：");
			String gs = sc.next();
			shopgs[e] = gs;
			e++;
			System.out.println("输入成功，请问是否返回? ");
			System.out.println("确定返回请按1，  继续输入请按2, 退出程序请按3");
			int pd = sc.nextInt();
			boolean flag = true;
			while (flag == true) {
				if (pd == 1) {
					shop();
					flag = false;
				} else if (pd == 2) {
					addshop();
					flag = false;
				} else if (pd == 3) {
					System.exit(0);
					flag = false;
				} else {
					System.err.println("输入错误,重新输入，如果想返回上一层请按6，退出程序请按7");
					pd = sc.nextInt();
					if (pd == 6) {
						shop();
						break;
					} else if (pd == 7) {
						System.exit(0);
						break;
					}
					continue;
				}
			}
		} else if (num == 2) {
			System.out.println("请输入要添加的数量");
			int scount = sc.nextInt();
			String[] randommz = { "泡面", "辣条", "火腿肠", "娃哈哈奶茶", "卫龙辣条" };
			int[] randombh = { 1, 2, 3, 11, 12, 13, 14, 22, 25 };
			int[] randomjg = { 9, 29, 93, 191, 152, 213, 114, 222, 255 };
			int[] randomsl = { 9, 29, 93, 191, 152, 213, 114, 222, 255 };
			String[] randomgs = { "腾讯", "网易", "阿里", "百度", "新浪", "搜狐" };
			for (int i = 0; i < scount; i++) {
				Random random = new Random();
				int randomx = random.nextInt(randommz.length);
				shopmz[a] = randommz[randomx] + random.nextInt(99);
				a++;
				int randomx2 = random.nextInt(randombh.length);
				shopbh[b] = randombh[randomx2];
				b++;
				int randomx3 = random.nextInt(randomjg.length);
				shopjg[c] = randomjg[randomx3];
				c++;
				int randomx4 = random.nextInt(randomsl.length);
				shopsl[d] = randomsl[randomx4];
				d++;
				int randomx5 = random.nextInt(randomgs.length);
				shopgs[e] = randomgs[randomx5] + random.nextInt(99);
				e++;

			}
			System.out.println("随机信息已经添加成功，请选择下一步操作：");
			System.out.println("1.继续添加、2.返回上一层、3.退出系统");
			boolean flag = true;
			scount = sc.nextInt();
			while (flag == true) {
				if (scount == 1) {
					addshop();
					flag = false;
				} else if (scount == 2) {
					shop();
					flag = false;
				} else if (scount == 3) {
					System.exit(0);
					flag = false;
				} else {
					System.err.println("输入错误，请重新输入");
					scount = sc.nextInt();
				}
			}

		} else {
			System.err.println("输入错误");
		}

	}

	public static void delshop() { // 删除商品
		System.out.println("请输入选择删除商品的名称或者商品编号!");
		System.out.println("选择商品名称请按1，选择商品编号请按2,返回请按3，退出程序请按4");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		boolean flag = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		while (flag == true) {
			if (pd == 1) {
				System.out.println("请输入您要删除的商品名称：");
				String name = sc.next();
				for (int i = 0; i < shopmz.length; i++) {
					while (flag2 == true) {
						if (name.equals(shopmz[i])) {
							System.out.println("您要删除的商品信息为：");
							System.out.println("商品名称:" + shopmz[i] + " " + "商品编号:" + shopbh[i] + " " + "商品价格:"
									+ shopjg[i] + " " + "商品数量:" + shopsl[i] + " " + "商品公司:" + shopgs[i]);
							System.out.println("请确认是否删除：确定请按y 取消并返回请按n");
							String pd2 = sc.next();
							while (flag3 == true) {
								if (pd2.equals("y")) {
									shopmz[i] = null;
									shopbh[i] = 0;
									shopjg[i] = 0;
									shopsl[i] = 0;
									shopgs[i] = null;
									System.out.println("商品已删除，继续删除请按y，返回请按n");
									String pd3 = sc.next();
									while (flag4 = true) {
										if (pd3.equals("y")) {
											delshop();
											flag4 = false;
										} else if (pd3.equals("n")) {
											shop();
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入");
											pd3 = sc.next();
											continue;
										}
									}
								} else if (pd2.equals("n")) {
									shop();
									flag3 = false;
								} else {
									System.err.println("输入错误,请重新输入");
									pd2 = sc.next();
									continue;
								}
							}
						} else {
							System.err.println("输入错误,您重新输入，如果想返回上一层请按8，退出程序请按9");
							pd = sc.nextInt();
							if (pd == 8) {
								shop();
								break;
							} else if (pd == 9) {
								System.exit(0);
								break;
							}
							continue;
						}
					}
				}
			} else if (pd == 2) {
				System.out.println("请输入您要删除的商品编号：");
				int name2 = sc.nextInt();
				for (int i = 0; i < shopbh.length; i++) {
					while (flag2 == true) {
						if (name2 == shopbh[i]) {
							System.out.println("您要删除的商品信息为：");
							System.out.println("商品名称:" + shopmz[i] + " " + "商品编号:" + shopbh[i] + " " + "商品价格:"
									+ shopjg[i] + " " + "商品数量:" + shopsl[i] + " " + "商品公司:" + shopgs[i]);
							System.out.println("请确认是否删除：确定请按y 取消并返回请按n");
							String pd2 = sc.next();
							while (flag3 == true) {
								if (pd2.equals("y")) {
									shopmz[i] = null;
									shopbh[i] = 0;
									shopjg[i] = 0;
									shopsl[i] = 0;
									shopgs[i] = null;
									System.out.println("商品已删除，继续删除请按y，返回请按n");
									String pd3 = sc.next();
									while (flag4 = true) {
										if (pd3.equals("y")) {
											delshop();
											flag4 = false;
										} else if (pd3.equals("n")) {
											shop();
											flag4 = false;
										} else {
											System.err.println("输入错误,您重新输入，如果想返回上一层请按1，退出程序请按2");
											int pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2.equals("n")) {
									shop();
									flag3 = false;
								} else {
									System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
									int pd4 = sc.nextInt();
									if (pd4 == 1) {
										shop();
										break;
									} else if (pd4 == 2) {
										System.exit(0);
										break;
									}
									continue;
								}
							}
						} else {
							pd = sc.nextInt();
							if (pd == 1) {
								shop();
								break;
							} else if (pd == 2) {
								System.exit(0);
								break;
							}
							continue;
						}
					}
				}
			} else if (pd == 3) {
				shop();
				break;
			} else if (pd == 4) {
				System.exit(0);
				break;
			}

			else {
				pd = sc.nextInt();
				if (pd == 1) {
					shop();
					break;
				} else if (pd == 2) {
					System.exit(0);
					break;
				}
				continue;
			}
		}
	}

	public static void modshop() { // 修改商品
		System.out.println("请输入选择修改的商品名称或者商品编号!");
		System.out.println("选择商品名称请按1，选择商品编号请按2,返回请按3，退出程序请按4");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		boolean flag = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		while (flag == true) {
			if (pd == 1) {
				System.out.println("请输入您要修改的商品名称：");
				String name = sc.next();
				for (int i = 0; i < shopmz.length; i++) {
					while (flag2 == true) {
						if (name.equals(shopmz[i])) {
							System.out.println("您要修改的商品信息为：");
							System.out.println("商品名称:" + shopmz[i] + " " + "商品编号:" + shopbh[i] + " " + "商品价格:"
									+ shopjg[i] + " " + "商品数量:" + shopsl[i] + " " + "商品公司:" + shopgs[i]);
							System.out.println("请选择修改部分:1.商品名称、2.商品编号、3.商品价格、4.商品数量、5.商品公司、6.返回上一层、7.退出系统");
							int pd2 = sc.nextInt();
							while (flag3 == true) {

								if (pd2 == 1) {
									System.out.println("请输入您要修改的内容");
									String pd3 = sc.next();
									shopmz[i] = pd3;
									System.out.println("您已成功将信息更新为:" + shopmz[i]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								}

								else if (pd2 == 2) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopbh[i] = pd3;
									System.out.println("您已成功将信息更新为:" + shopbh[i]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								}

								else if (pd2 == 3) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopjg[i] = pd3;
									System.out.println("您已成功将信息更新为:" + shopjg[i]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								}

								else if (pd2 == 4) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopsl[i] = pd3;
									System.out.println("您已成功将信息更新为:" + shopsl[i]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								}

								else if (pd2 == 5) {
									System.out.println("请输入您要修改的内容");
									String pd3 = sc.next();
									shopgs[i] = pd3;
									System.out.println("您已成功将信息更新为:" + shopgs[i]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								}

								else if (pd2 == 6) {
									shop();
									flag3 = false;
								}

								else if (pd2 == 7) {
									System.exit(0);
									flag3 = false;
								}

								else {
									System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
									pd2 = sc.nextInt();
									if (pd2 == 1) {
										shop();
										break;
									} else if (pd2 == 2) {
										System.exit(0);
										break;
									}
									continue;
								}
							}
						}

					}
				}
			} else if (pd == 2) {
				System.out.println("请输入您要修改的商品编号：");
				int name2 = sc.nextInt();
				for (int i1 = 0; i1 < shopbh.length; i1++) {
					while (flag2 == true) {
						if (name2 == shopbh[i1]) {
							System.out.println("您要修改的商品信息为：");
							System.out.println("商品名称:" + shopmz[i1] + " " + "商品编号:" + shopbh[i1] + " " + "商品价格:"
									+ shopjg[i1] + " " + "商品数量:" + shopsl[i1] + " " + "商品公司:" + shopgs[i1]);
							System.out.println("请选择修改部分:1.商品名称、2.商品编号、3.商品价格、4.商品数量、5.商品公司、6.返回上一层、7.退出系统");
							int pd2 = sc.nextInt();
							while (flag3 == true) {
								if (pd2 == 1) {
									System.out.println("请输入您要修改的内容");
									String pd3 = sc.next();
									shopmz[i1] = pd3;
									System.out.println("您已成功将信息更新为:" + shopmz[i1]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2 == 2) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopbh[i1] = pd3;
									System.out.println("您已成功将信息更新为:" + shopbh[i1]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2 == 3) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopjg[i1] = pd3;
									System.out.println("您已成功将信息更新为:" + shopjg[i1]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2 == 4) {
									System.out.println("请输入您要修改的内容");
									int pd3 = sc.nextInt();
									shopsl[i1] = pd3;
									System.out.println("您已成功将信息更新为:" + shopsl[i1]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2 == 5) {
									System.out.println("请输入您要修改的内容");
									String pd3 = sc.next();
									shopgs[i1] = pd3;
									System.out.println("您已成功将信息更新为:" + shopgs[i1]);
									System.out.println("继续更改请按1，返回上一层请按2，退出系统请按3");
									while (flag4 = true) {
										int pd4 = sc.nextInt();
										if (pd4 == 1) {
											modshop();
											flag4 = false;
										} else if (pd4 == 2) {
											shop();
											flag4 = false;
										} else if (pd4 == 3) {
											System.exit(0);
											flag4 = false;
										} else {
											System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
											pd4 = sc.nextInt();
											if (pd4 == 1) {
												shop();
												break;
											} else if (pd4 == 2) {
												System.exit(0);
												break;
											}
											continue;
										}
									}
								} else if (pd2 == 6) {
									shop();
									flag3 = false;
								} else if (pd2 == 7) {
									System.exit(0);
									flag3 = false;
								}

								else {
									System.err.println("输入错误,请重新输入，如果想返回上一层请按1，退出程序请按2");
									pd2 = sc.nextInt();
									if (pd2 == 1) {
										shop();
										break;
									} else if (pd2 == 2) {
										System.exit(0);
										break;
									}
									continue;
								}

							}
						}
					}
				}
			} else if (pd == 3) {
				shop();
				break;
			} else if (pd == 4) {
				System.exit(0);
				break;
			}

			else {
				pd = sc.nextInt();
				if (pd == 1) {
					shop();
					break;
				} else if (pd == 2) {
					System.exit(0);
					break;
				} else {
					continue;
				}
			}
		}
	}

	public static void broshop() { // 查看商品
		System.out.println("请选择您要查看的方式:");
		System.out.println("1.查看单个商品信息");
		System.out.println("2.浏览全部商品信息");
		System.out.println("3.浏览部分商品信息");
		System.out.println("4.返回上一层");
		System.out.println("5.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			broone();
			break;
		case 2:
			broall();
			break;
		case 3:
			bropart();
			break;
		case 4:
			shop();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.err.println("输入错误，请重新输入。如果返回上一层请按4，退出程序请按5");
			int pd = sc.nextInt();
			boolean flag = true;
			while (flag == true) {
				if (pd == 1) {
					broone();
					break;
				} else if (pd == 2) {
					broall();
					break;
				} else if (pd == 3) {
					bropart();
					break;
				} else if (pd == 4) {
					shop();
					break;
				} else if (pd == 5) {
					System.exit(0);
					break;
				} else {
					System.err.println("输入错误,请重新输入，如果想返回上一层请按4，退出程序请按5");
					pd = sc.nextInt();
					if (pd == 4) {
						shop();
						break;
					} else if (pd == 5) {
						System.exit(0);
						break;
					}
					continue;
				}
			}
		}
	}

	public static void broone() { // 查看单个商品信息
		System.out.println("请选择您要查询的方式:");
		System.out.println("1.商品名称查询、2.商品编号查询、3.返回上一层、4.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int j = 0;
		boolean flag = true;
		while (flag == true) {
			if (num == 1) {
				System.out.println("请输入您要查看的商品名称:");
				String name = sc.next();
				for (int i = 0; i < shopmz.length; i++) {
					if (name.equals(shopmz[i])) {
						System.out.println("该商品的信息为:");
						System.out.println("商品名称:" + shopmz[i] + "商品编号:" + shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
								+ shopsl[i] + "商品公司:" + shopgs[i]);
						j++;
					}
				}
				if (j != 0) {
					System.out.println("所有符合条件的" + j + "条信息已经输出");
					System.out.println("如果想继续查询请按1，返回上一层请按2，退出系统请按3");
					num = sc.nextInt();
					if (num == 1) {
						broone();
						break;
					} else if (num == 2) {
						broshop();
						break;
					} else if (num == 3) {
						System.exit(0);
						break;
					} else {
						System.err.println("输入错误。请重新输入");
						num = sc.nextInt();
					}
				}
				if (j == 0) {
					System.err.println("查无信息,如果想重新输入请按1，返回上一层请按,2，退出程序请按3");
					num = sc.nextInt();
					boolean flag2 = true;
					while (flag2 == true) {
						if (num == 1) {
							broone();
							break;
						} else if (num == 2) {
							broshop();
							break;
						} else if (num == 3) {
							System.exit(0);
							break;
						} else {
							System.err.println("输入错误，请重新输入");
							num = sc.nextInt();
						}
					}
				}

			} else if (num == 2) {
				System.out.println("请输入您要查看的商品编号:");
				int name = sc.nextInt();
				for (int i = 0; i < shopmz.length; i++) {
					if (name == shopbh[i]) {
						System.out.println("该商品的信息为:");
						System.out.println("商品名称:" + shopmz[i] + "商品编号:" + shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
								+ shopsl[i] + "商品公司:" + shopgs[i]);
						j++;
					}
				}
				if (j != 0) {
					System.out.println("所有符合条件的" + j + "条信息已经输出");
					System.out.println("如果想继续查询请按1，返回上一层请按2，退出系统请按3");
					num = sc.nextInt();
					if (num == 1) {
						broone();
						break;
					} else if (num == 2) {
						broshop();
						break;
					} else if (num == 3) {
						System.exit(0);
						break;
					} else {
						System.err.println("输入错误。请重新输入");
						num = sc.nextInt();
					}
				}
				if (j == 0) {
					System.err.println("查无信息,如果想重新输入请按1，返回上一层请按,2，退出程序请按3");
					num = sc.nextInt();
					boolean flag2 = true;
					while (flag2 == true) {
						if (num == 1) {
							broone();
							break;
						} else if (num == 2) {
							broshop();
							break;
						} else if (num == 3) {
							System.exit(0);
							break;
						} else {
							System.err.println("输入错误，请重新输入");
							num = sc.nextInt();
						}
					}
				}

			} else if (num == 3) {
				broshop();
			} else if (num == 4) {
				System.exit(0);
			} else {
				System.err.println("输入错误。请重新输入");
				num = sc.nextInt();
			}
		}
	}

	public static void broall() { // 浏览全部商品信息
		int num = 0;
		System.out.println("请选择显示模式：1.全部显示、2.分页显示");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		boolean flag = true;
		if (pd == 1) { // 全部显示
			System.out.println("下面将输出所有商品信息（以录入顺序）");
			for (int i = 0; i < a; i++) {
				if (shopmz[i] != null) {
					System.out.println("商品名称:" + shopmz[i] + "商品编号:" + shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
							+ shopsl[i] + "商品公司:" + shopgs[i]);
					num++;
				}
			}
			System.out.println("共计" + num + "条信息已经全部输出。");
			System.out.println("如果想返回上一层，请按1，如果想退出程序，请按2");
			int num2 = sc.nextInt();

			while (flag == true) {
				if (num2 == 1) {
					broshop();
					flag = false;
				} else if (num2 == 2) {
					System.exit(0);
					flag = false;
				} else {
					System.err.println("输入错误，请重新输入");
					num2 = sc.nextInt();
				}
			}
		} else if (pd == 2) { // 分页显示
			int i = 0;// 信息输出个数
			System.out.println("下面将以分页的形式显示商品信息，每页共十个。");
			if (a % 10 == 0) {
				yemian = a / 10;
			} else {
				yemian = a / 10 + 1;
			}
			page = new String[yemian][10];
			if (page[0][0] == null) {
				while (yemian2 <= yemian && i <= a && shopmz[i] != null) { // 将信息输入二维数组，用于分页显示
					String name = "商品名称:" + shopmz[i];
					String bianhao = "商品编号:" + shopbh[i];
					String jiage = "商品价格:" + shopjg[i];
					String shuliang = "商品数量:" + shopsl[i];
					String gongsi = "商品公司:" + shopgs[i];
					String information = name + bianhao + jiage + shuliang + gongsi;
					if (number < 10) {
						page[yemian2][number] = information;
//						System.out.println(page[yemian2][number]);
						i++;
						number++;
					} else {
						number = 0;
						yemian2++;
					}
				}
				yemian2 = 0;
				number = 0;
				fenye();
			} else {
				yemian2 = 0;
				number = 0;
				fenye();
			}

		} else if (pd == 3) {
			broall();
			flag = false;
		} else {
			System.err.println("输入错误，请重新输入");
		}
	}

	public static void fenye() { // 分页显示
		while (yemian2 <= yemian) {
			while (number < page[yemian2].length && page[yemian2][number] != null) {
				System.out.println(page[yemian2][number]);
				number++;
			}

			yemian2s++;
			System.out.println("当前为第" + yemian2s + "页，共" + yemian + "页");
			if (yemian2 == yemian - 1) {
				yemian2 = 0;
				number = 0;
				yemian2s = 0;
				System.out.println("所有信息已经输出完成，请选择下一步操作：");
				System.out.println("返回上一层请按1，跳转页面请按2，退出系统请按3");
				Scanner sc = new Scanner(System.in);
				int pd2 = sc.nextInt();
				boolean flag4 = true;
				while (flag4 == true) {
					if (pd2 == 1) {
						broall();
						flag4 = false;
					} else if (pd2 == 2) {
						tzpage();
						flag4 = false;
					} else if (pd2 == 3) {
						System.exit(0);
						flag4 = false;
					} else {
						System.err.println("输入错误，请重新输入");
						pd2 = sc.nextInt();
					}
				}
			} else {
				System.out.println("是否继续输出，继续输出请按1，跳转页面请按2，返回上一层请按3");
				yemian2++;
				Scanner sc = new Scanner(System.in);
				int pd = sc.nextInt();
				boolean flag2 = true;
				while (flag2 == true) {
					if (pd == 1) {
						number = 1;
						fenye();
					} else if (pd == 2) {
						tzpage();
						flag2 = false;
					} else if (pd == 3) {
						broall();
						flag2 = false;
					} else {
						System.err.println("输入错误，请重新输入");
						pd = sc.nextInt();
					}
				}
			}
		}
	}

	public static void tzpage() {
		System.out.println("共"+yemian+"页");
		System.out.println("请输入要跳转的页面");
		Scanner sc = new Scanner(System.in);
		int pd = sc.nextInt();
		boolean flag = true;
		while (flag == true) {
			if (pd < 0 || pd > yemian) {
				System.err.println("您输入的数字超过范围，请重新输入");
				pd = sc.nextInt();
			} else {
				yemian2 = pd-1;
				for (int m = 0; m < 10; m++) {
					if (page[yemian2][m] != null) {
						System.out.println(page[yemian2][m]);
					}
				}
				flag = false;
				yemian2 = 0;
				System.out.println("请选择您的下一步操作：");
				System.out.println("1.继续跳转。2.返回上一层。3.退出系统");
				pd = sc.nextInt();
				boolean flag2 = true;
				while (flag2 == true) {
					if (pd == 1) {
						tzpage();
						flag2 = false;
					} else if (pd == 2) {
						broall();
						flag2 = false;
					} else if (pd == 3) {
						System.exit(0);
						flag2 = false;
					} else {
						System.err.println("输入错误，请重新输入");
						pd = sc.nextInt();
					}
				}
			}
		}
	}

	public static void bropart() { // 浏览部分商品信息
		System.out.println("您可以选择以下功能：");
		System.out.println("1.按照价格区间查找、2.模糊查找、3.返回上一层、4.退出系统");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean flag = true;
		int jgmin = 0; // 价格区间最小值
		int jgmax = 0; // 价格区间最小值
		int scount = 0;// 符合条件的信息数
		int scount2 = 0;// 符合条件的信息数
		while (flag == true) {
			if (num == 1) { // 按照价格区间查找
				System.out.println("请输入您想搜索的价格区间最小值：");
				num = sc.nextInt();
				jgmin = num;
				System.out.println("请输入您想搜索的价格区间最大值：");
				num = sc.nextInt();
				jgmax = num;
				for (int i = 0; i < shopjg.length; i++) {
					if (shopjg[i] >= jgmin && shopjg[i] <= jgmax) {
						System.out.println("商品名称:" + shopmz[i] + "商品编号:" + shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
								+ shopsl[i] + "商品公司:" + shopgs[i]);
						scount++;
					}
				}
				System.out.println("共有" + scount + "条符合条件的信息，已经全部显示");
				System.out.println("如果想返回上一层，请按1.如果想退出系统，请按2");
				num = sc.nextInt();
				boolean flag2 = true;
				while (flag == true) {
					if (num == 1) {
						bropart();
						flag = false;
					} else if (num == 2) {
						System.exit(0);
						flag = false;
					} else {
						System.err.println("输入错误，请重新输入");
						num = sc.nextInt();
					}
				}
			} else if (num == 2) {// 模糊查找
				System.out.println("请输入您想查找的商品名称的关键字:");
				String keyword = sc.next();
				for (int i = 0; i < a; i++) {
					boolean result = shopmz[i].contains(keyword);
					if (result == true) {
						System.out.println("商品名称:" + shopmz[i] + "商品编号:" + shopbh[i] + "商品价格:" + shopjg[i] + "商品数量:"
								+ shopsl[i] + "商品公司:" + shopgs[i]);
						scount++;
					} else {
						continue;
					}
				}
				System.out.println("共有" + scount + "条符合条件的信息，已经全部显示");
				System.out.println("如果想返回上一层，请按1.如果想退出系统，请按2");
				num = sc.nextInt();
				boolean flag2 = true;
				while (flag == true) {
					if (num == 1) {
						bropart();
						flag = false;
					} else if (num == 2) {
						System.exit(0);
						flag = false;
					} else {
						System.err.println("输入错误，请重新输入");
						num = sc.nextInt();
					}
				}

			} else if (num == 3) {
				broshop();
				flag = false;
			} else if (num == 4) {
				System.exit(0);
				flag = false;
			} else {
				System.err.println("输入错误，请重新输入，如果想返回上一层请按5，退出系统请按6");
				num = sc.nextInt();
			}
		}

	}

	public static void user() { // 用户管理界面
		System.out.println("**************************");
		System.out.println("请选择功能:");
		System.out.println("1.添加用户");
		System.out.println("2.删除用户");
		System.out.println("3.修改用户");
		System.out.println("4.查看用户");
		System.out.println("5.退出系统");
		System.out.println("**************************");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch (num) {
		case 1:
			adduser();
			break;
		case 2:
			deluser();
			break;
		case 3:
			moduser();
			break;
		case 4:
			brouser();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.err.println("输入错误，如果返回上一层请按1，退出程序请按2");
			int pd = sc.nextInt();
			if (pd == 1) {
				menu();
				break;
			} else if (pd == 2) {
				System.exit(0);
				break;
			}
		}
	}

	public static void adduser() {
		System.out.println("123");
	}

	public static void deluser() {
		System.out.println("123");
	}

	public static void moduser() {
		System.out.println("123");
	}

	public static void brouser() {
		System.out.println("123");
	}

}
