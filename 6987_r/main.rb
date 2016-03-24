for i in 0..0
  test_case = Array.new
  String(gets).split(' ').each_slice(3).to_a.each do |slice|
    test_case.push({:win => slice[0].to_i, :draw => slice[1].to_i, :lose => slice[2].to_i})
  end

  while test_case.length != 0
    max_element = test_case.max_by {|value| value.values.max }
    max_pair = max_element.max_by {|k, v| v }
    test_case.delete max_element
    target_key = '';

    if max_pair[0] == 'win'
      target_key = 'lose'
    elsif max_pair[0] == 'lose'
      target_key = 'win'
    else
      target_key = 'draw'
    end

    to_be_subtracted = max_pair[1];

    for j in 0..test_case.size - 1
      if test_case[j][target_key] != 0
        test_case[j][target_key] = test_case[j][target_key] - 1
      end


    end

  end




end