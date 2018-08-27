package e07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
// 64% (timeout error) https://app.codility.com/demo/results/trainingDTDBDE-KS7/
public class StoneWall {

	protected static class Point {
		protected int x;
		protected int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Point add(int dx, int dy) {
			return new Point(x+dx, y+dy);
		}

		public Point sub(int dx, int dy) {
			return new Point(x-dx, y-dy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Point)) return false;
			Point point = (Point) o;
			return x == point.x &&
				y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}

	protected static class Block {
		protected Point left;
		protected Point right;

		public Block(Point left, Point right) {
			this.left = left;
			this.right = right;
		}

		public Block(int lx, int ly, int rx, int ry) {
			this(new Point(lx, ly), new Point(rx, ry));
		}

		public Block add(int dx, int dy) {
			right = right.add(dx, dy);
			return this;
		}

		public boolean isEmpty() {
			return left.getY() > right.getY();
		}

		public Point getLeft() {
			return left;
		}

		public Point getRight() {
			return right;
		}

		public int getWidth() {
			return right.getX() - left.getX() + 1;
		}

		public int getHeight() {
			return right.getY() - left.getY() + 1;
		}

		/**
		 * Checks is this block can be fully intersected with other block
		 */
		public boolean intersects(Block block) {
//			return getLeft().getY() >= block.getLeft().getY()
//				&& getRight().getY() <= block.getRight().getY();
			return getLeft().getY() == block.getLeft().getY() // more strict condition
				&& getRight().getY() <= block.getRight().getY();
		}

		/**
		 * Joins fully intersected block to this block. Return resulting block which is the result of subtracting intersecting block from
		 * the block passed as as argument.
		 */
		public Block join(Block block) {
			if (!intersects(block))
				throw new IllegalArgumentException(String.format("Block: %s doesn't intersect with block: %s", this, block));

			this.add(1, 0);
			return new Block(block.getLeft().add(0, this.getHeight()), block.getRight());
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Block)) return false;
			Block block = (Block) o;
			return Objects.equals(left, block.left) &&
				Objects.equals(right, block.right);
		}

		@Override
		public int hashCode() {
			return Objects.hash(left, right);
		}

		@Override
		public String toString() {
			return "Block{" +
				"left=" + left +
				", right=" + right +
				", width=" + getWidth() +
				", height=" + getHeight() +
				'}';
		}
	}

	public int solution(int[] h) {
		List<Block> blocks = new ArrayList<>();
		int count = 0;

		for (int x=1; x<=h.length; x++) {
			int height = h[x-1];
			Block currentBlock = new Block(x, 1, x, height);

			for (Iterator<Block> it = blocks.iterator(); it.hasNext(); ) {
				Block existingBlock = it.next();
				if (existingBlock.intersects(currentBlock))
					currentBlock = existingBlock.join(currentBlock);
				else {
					count++;
					it.remove(); // existing block is finished
				}
			}

			if (!currentBlock.isEmpty())
				blocks.add(currentBlock);
		}

		return count + blocks.size();
	}

	public static void main(String [] args) {
		System.out.println(new StoneWall().solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}));
	}

}
