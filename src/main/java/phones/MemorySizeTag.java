package phones;

public class MemorySizeTag extends Tag {
    private int memorySize;

    public MemorySizeTag(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getMemorySize() == memorySize;
    }
}
