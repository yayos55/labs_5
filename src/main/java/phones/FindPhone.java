package phones;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class FindPhone {
    private List<Phone> data = new PhoneDB().getPhoneData();

    public List<Phone> byColor(Color col) {
        return search(new ColorTag(col));
    }

    public List<Phone> byModel(String mod) {
        return search(new ModelTag(mod));
    }

    public List<Phone> byMSize(int memSize) {
        return search(new MemorySizeTag(memSize));
    }

    public List<Phone> byModelAndPriceLow(String mod, double price) {
        return search(new ModelTag(mod), new PriceTag(price));
    }

    public List<Phone> byMSizeAndNotColor(int memSize, Color col) {
        List<Phone> find = new LinkedList<>();
        for (Phone ph : data) {
            if (ph.getMemorySize() == memSize && !(ph.getColor() == col)) {
                find.add(ph);
            }
        }
        return find;
    }

    public List<Phone> byModelAndPriceLowAndColor(String mod, double price, Color color) {
        return search(new ModelTag(mod), new PriceTag(price), new ColorTag(color));
    }

    private List<Phone> search(Tag... tags) {
        List<Phone> find = new LinkedList<>();
        for (Phone ph : data) {
            boolean matches = true;
            for (Tag tag : tags) {
                if (!tag.find(ph)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                find.add(ph);
            }
        }
        return find;
    }
}
